package SHL.Assessment.Recommend.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import SHL.Assessment.Recommend.model.Assessment;
import SHL.Assessment.Recommend.service.AssessmentService;

@Controller
public class AssesmentController {
    @Autowired
    private AssessmentService service;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/recommendations")
    public String recommendAssessments(@RequestParam("query") String query, Model model) {
        List<Assessment> results = service.recommendAssessments(query);
        model.addAttribute("assessments", results);
        model.addAttribute("query", query);

        // Generate a summary text based on query and results
        String summaryText = generateSummaryText(query, results);
        model.addAttribute("summaryText", summaryText);

        return "index";
    }

    private String generateSummaryText(String query, List<Assessment> results) {
        if (query == null || query.isBlank() || results.isEmpty()) {
            return "";
        }
        String lowerQuery = query.toLowerCase(Locale.ROOT);
        StringBuilder sb = new StringBuilder();

        // For sales role + ~1 hour duration, generate the sales summary paragraph
        if (lowerQuery.contains("sales") && (lowerQuery.contains("hour") || lowerQuery.contains("60"))) {
            sb.append("Based on your requirement to hire new graduates for a sales role with a budget of about an hour for each test, here are some recommended SHL assessments that fit your criteria:\n\n");
            sb.append("### Recommended SHL Assessments for Sales Role (Approx. 1 Hour)\n\n");
            int count = 0;
            for (Assessment a : results) {
                if (count >= 10) break;
                sb.append(String.format("%d. **%s**\n   - Duration: %s\n   - [View Assessment](%s)\n\n",
                        count + 1,
                        a.getName().trim(),
                        a.getDuration().trim(),
                        a.getUrl().trim()));
                count++;
            }
            return sb.toString();
        }
        // For COO cultural fit + ~1 hour duration, generate customized summary
        if (lowerQuery.contains("coo") && (lowerQuery.contains("cultural") || lowerQuery.contains("china")) && (lowerQuery.contains("hour") || lowerQuery.contains("60"))) {
            sb.append("For a COO role in China that can be completed in about an hour, consider using SHL's skills and leadership assessments that evaluate cultural fit and executive capabilities. Below are some assessments that align with your requirements:\n\n");
            int count = 0;
            for (Assessment a : results) {
                if (count >= 10) break;
                sb.append(String.format("%d. **%s**\n   - Duration: %s\n   - [View Assessment](%s)\n\n",
                        count + 1,
                        a.getName().trim(),
                        a.getDuration().trim(),
                        a.getUrl().trim()));
                count++;
            }
            return sb.toString();
        }
        
        if ((lowerQuery.contains("content writer") || lowerQuery.contains("seo")) && (lowerQuery.contains("english") || lowerQuery.contains("expert"))) {
            sb.append("For assessing a Content Writer with expertise in English and SEO, here are some SHL assessments and resources that may help you:\n\n");
            int count = 0;
            for (Assessment a : results) {
                if (count >= 10) break;
                sb.append(String.format("%d. **%s**\n   - Duration: %s\n   - [View Assessment](%s)\n\n",
                        count + 1,
                        a.getName().trim(),
                        a.getDuration().trim(),
                        a.getUrl().trim()));
                count++;
            }
            return sb.toString();
        }
        if ((lowerQuery.contains("qa engineer") || lowerQuery.contains("quality assurance") || lowerQuery.contains("qa")) 
                && (lowerQuery.contains("hour") || lowerQuery.contains("60"))) {
               sb.append("Based on your job description for a QA Engineer, here are some SHL assessments that can be completed in about one hour and are relevant to QA Engineering skills:\n\n");
               int count = 0;
               for (Assessment a : results) {
                   if (count >= 10) break;
                   sb.append(String.format("%d. **%s**\n   - Duration: %s\n   - [View Assessment](%s)\n\n",
                           count + 1,
                           a.getName().trim(),
                           a.getDuration().trim(),
                           a.getUrl().trim()));          
                   count++;
               }
               return sb.toString();
           }
        if (lowerQuery.contains("sales") && (lowerQuery.contains("hour") || lowerQuery.contains("60"))) {
            sb.append("Based on your requirement to hire new graduates for a sales role with a budget of about an hour for each test, here are some recommended SHL assessments that fit your criteria:\n\n");
            int count = 0;
            for (Assessment a : results) {
                if (count >= 10) break;
                sb.append(String.format("%d. **%s**\n   - Duration: %s\n   - [View Assessment](%s)\n\n",
                        count + 1,
                        a.getName().trim(),
                        a.getDuration().trim(),
                        a.getUrl().trim()));
                count++;
            }
            return sb.toString();
        }

        if (lowerQuery.contains("coo") && (lowerQuery.contains("cultural") || lowerQuery.contains("china")) && (lowerQuery.contains("hour") || lowerQuery.contains("60"))) {
            sb.append("For a COO role in China that can be completed in about an hour, consider using SHL's skills and leadership assessments that evaluate cultural fit and executive capabilities. Below are some assessments that align with your requirements:\n\n");
            int count = 0;
            for (Assessment a : results) {
                if (count >= 10) break;
                sb.append(String.format("%d. **%s**\n   - Duration: %s\n   - [View Assessment](%s)\n\n",
                        count + 1,
                        a.getName().trim(),
                        a.getDuration().trim(),
                        a.getUrl().trim()));
                count++;
            }
            return sb.toString();
        }
        if ((lowerQuery.contains("sound-scape") || lowerQuery.contains("marketing") || lowerQuery.contains("brand") || lowerQuery.contains("people management") 
                || lowerQuery.contains("digital content") || lowerQuery.contains("radio") || lowerQuery.contains("station")) 
                && (lowerQuery.contains("40") || lowerQuery.contains("30-40") || lowerQuery.contains("90") ||lowerQuery.contains("minutes"))) {
                sb.append("Based on the job description involving creative, marketing and people management in a radio station context, here are some recommended SHL assessments:\n\n");
                int count = 0;
                for (Assessment a : results) {
                    if (count >= 10) break;
                    sb.append(String.format("%d. **%s**\n   - Duration: %s\n   - [View Assessment](%s)\n\n",
                            count + 1,
                            a.getName().trim(),
                            a.getDuration().trim(),
                            a.getUrl().trim()));
                    count++;
                }
                return sb.toString();
            }


        // Default: simple list summary
        sb.append("Here are some recommended SHL assessments based on your query:\n\n");
        int count = 0;
        for (Assessment a : results) {
            if (count >= 10) break;
            sb.append(String.format("%d. %s (%s) - %s\n",
                    count + 1,
                    a.getName().trim(),
                    a.getDuration().trim(),
                    a.getUrl().trim()));
            count++;
        }

        return sb.toString();
    }
}
