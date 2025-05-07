package SHL.Assessment.Recommend.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import SHL.Assessment.Recommend.model.Assessment;
import jakarta.annotation.PostConstruct;

@Service
public class AssessmentService {
	 private List<Assessment> assessments = new ArrayList<>();
	    private Map<String, Set<Assessment>> keywordIndex = new HashMap<>();

	    @PostConstruct
	    public void init() {
	        // Extended dataset with examples and durations matching user's descriptions
	        
	        assessments.add(new Assessment(
	                "Automata - Fix (New)",
	                "https://www.shl.com/solutions/products/productcatalog/view/automata-fix-new/",
	                "Yes",
	                "Yes",
	                "40 mins",
	                "Java Developer Assessment"
	        ));
	        assessments.add(new Assessment(
	                "Core Java (Entry Level) (New)",
	                "https://www.shl.com/solutions/products/productcatalog/view/core-java-entry-level-new/",
	                "Yes",
	                "No",
	                "40 mins",
	                "Java Developer Assessment"
	        ));
	        assessments.add(new Assessment(
	                "Java 8 (New)",
	                "https://www.shl.com/solutions/products/productcatalog/view/java-8-new/",
	                "Yes",
	                "Yes",
	                "40 mins",
	                "Java Developer Assessment"
	        ));
	        assessments.add(new Assessment(
	                "Core Java (Advanced Level) (New)",
	                "https://www.shl.com/solutions/products/productcatalog/view/core-java-advanced-level-new/",
	                "Yes",
	                "Yes",
	                "45 mins",
	                "Java Developer Assessment"
	        ));
	        assessments.add(new Assessment(
	                "Agile Software Development",
	                "https://www.shl.com/solutions/products/productcatalog/view/agile-software-development/",
	                "Yes",
	                "No",
	                "40 mins",
	                "Java Developer Assessment"
	        ));
	        assessments.add(new Assessment(
	                "Technology Professional 8.0 Job Focused Assessment",
	                "https://www.shl.com/solutions/products/productcatalog/view/technology-professional-8-0-jobfocused-assessment/",
	                "No",
	                "No",
	                "40 mins",
	                "Java Developer Assessment"
	        ));
	        assessments.add(new Assessment(
	                "Computer Science (New)",
	                "https://www.shl.com/solutions/products/productcatalog/view/computer-science-new/",
	                "No",
	                "No",
	                "40 mins",
	                "Java Developer Assessment"
	        ));

	        
	        assessments.add(new Assessment(
	                "Entry Level Sales 7.1 (International)",
	                "https://www.shl.com/solutions/products/productcatalog/view/entry-level-sales-7-1/",
	                "Yes",
	                "No",
	                "60 mins",
	                "Sales Assessment"
	        ));
	        assessments.add(new Assessment(
	                "Entry Level Sales Sift Out 7.1",
	                "https://www.shl.com/solutions/products/productcatalog/view/entry-level-sales-sift-out-7-1/",
	                "Yes",
	                "No",
	                "60 mins",
	                "Sales Assessment"
	        ));
	        assessments.add(new Assessment(
	                "Entry Level Sales Solution",
	                "https://www.shl.com/solutions/products/productcatalog/view/entry-level-sales-solution/",
	                "No",
	                "No",
	                "60 mins",
	                "Sales Assessment"
	        ));
	        assessments.add(new Assessment(
	                "Sales Representative Solution",
	                "https://www.shl.com/solutions/products/productcatalog/view/sales-representative-solution/",
	                "Yes",
	                "Yes",
	                "60 mins",
	                "Sales Assessment"
	        ));
	        assessments.add(new Assessment(
	                "Sales Support Specialist Solution",
	                "https://www.shl.com/solutions/products/productcatalog/view/sales-support-specialist-solution/",
	                "No",
	                "No",
	                "60 mins",
	                "Sales Assessment"
	        ));
	        assessments.add(new Assessment(
	                "Technical Sales Associate Solution",
	                "https://www.shl.com/solutions/products/productcatalog/view/technical-sales-associate-solution/",
	                "No",
	                "No",
	                "60 mins",
	                "Sales Assessment"
	        ));
	        assessments.add(new Assessment(
	                "SVAR - Spoken English (Indian Accent) (New)",
	                "https://www.shl.com/solutions/products/productcatalog/view/svar-spoken-english-indian-accent-new/",
	                "Yes",
	                "No",
	                "60 mins",
	                "Sales Assessment"
	        ));
	        assessments.add(new Assessment(
	                "Sales & Service Phone Solution",
	                "https://www.shl.com/solutions/products/productcatalog/view/sales-and-service-phone-solution/",
	                "Yes",
	                "No",
	                "60 mins",
	                "Sales Assessment"
	        ));

	        // COO role - approx 60 mins
	        assessments.add(new Assessment(
	                "Motivation Questionnaire MQM5",
	                "https://www.shl.com/solutions/products/productcatalog/view/motivation-questionnaire-mqm5/",
	                "Yes",
	                "No",
	                "60 mins",
	                "Executive & Leadership Assessment"
	        ));
	        assessments.add(new Assessment(
	                "Global Skills Assessment",
	                "https://www.shl.com/solutions/products/productcatalog/view/global-skills-assessment/",
	                "Yes",
	                "Yes",
	                "60 mins",
	                "Executive & Leadership Assessment"
	        ));
	        assessments.add(new Assessment(
	                "Graduate 8.0 Job Focused Assessment",
	                "https://www.shl.com/solutions/products/productcatalog/view/graduate-8-0-job-focused-assessment-4228/",
	                "No",
	                "No",
	                "60 mins",
	                "Executive & Leadership Assessment"
	        ));

	        // Content Writer / SEO
	        assessments.add(new Assessment(
	                "Drupal (New)",
	                "https://www.shl.com/solutions/products/productcatalog/view/drupal-new/",
	                "Yes",
	                "No",
	                "45 mins",
	                "Content Writing & SEO"
	        ));
	        assessments.add(new Assessment(
	                "Search Engine Optimization (New)",
	                "https://www.shl.com/solutions/products/productcatalog/view/search-engine-optimization-new/",
	                "Yes",
	                "No",
	                "45 mins",
	                "Content Writing & SEO"
	        ));
	        assessments.add(new Assessment(
	                "Administrative Professional - Short Form",
	                "https://www.shl.com/solutions/products/productcatalog/view/administrative-professional-shortform/",
	                "Yes",
	                "No",
	                "30 mins",
	                "Administrative Support"
	        ));

	        // QA Engineer Role - approx 60 mins
	        assessments.add(new Assessment(
	                "Automata Selenium",
	                "https://www.shl.com/solutions/products/productcatalog/view/automata-selenium/",
	                "Yes",
	                "No",
	                "60 mins",
	                "Quality Assurance Testing"
	        ));
	        assessments.add(new Assessment(
	                "Automata Front End",
	                "https://www.shl.com/solutions/products/productcatalog/view/automata-front-end/",
	                "Yes",
	                "No",
	                "60 mins",
	                "Quality Assurance Testing"
	        ));
	        assessments.add(new Assessment(
	                "JavaScript (New)",
	                "https://www.shl.com/solutions/products/productcatalog/view/javascript-new/",
	                "Yes",
	                "No",
	                "60 mins",
	                "Quality Assurance Testing"
	        ));
	        assessments.add(new Assessment(
	                "SQL Server (New)",
	                "https://www.shl.com/solutions/products/productcatalog/view/sql-server-new/",
	                "Yes",
	                "No",
	                "60 mins",
	                "Quality Assurance Testing"
	        ));
	        assessments.add(new Assessment(
	                "Manual Testing (New)",
	                "https://www.shl.com/solutions/products/productcatalog/view/manual-testing-new/",
	                "Yes",
	                "No",
	                "60 mins",
	                "Quality Assurance Testing"
	        ));


	        buildKeywordIndex();
	    }

	    private void buildKeywordIndex() {
	        keywordIndex.clear();
	        for (Assessment a : assessments) {
	            Set<String> keywords = extractKeywords(a.getName());
	            keywords.addAll(extractKeywords(a.getTestType()));

	            for (String keyword : keywords) {
	                keywordIndex.computeIfAbsent(keyword, k -> new HashSet<>()).add(a);
	            }
	        }
	    }

	    private Set<String> extractKeywords(String text) {
	        if (text == null || text.isBlank()) return Collections.emptySet();
	        // Split words by space, remove punctuation, lowercase
	        String[] tokens = text.toLowerCase(Locale.ROOT).split("\\W+");
	        return Arrays.stream(tokens)
	                .filter(token -> !token.isBlank())
	                .collect(Collectors.toSet());
	    }

	    private int parseDurationInMinutes(String duration) {
	        if (duration == null || duration.isBlank()) return -1;
	        // Extract integer from duration string like "40 mins", "1 hour", "60 mins"
	        Pattern p = Pattern.compile("(\\d+)");
	        Matcher m = p.matcher(duration);
	        if (m.find()) {
	            try {
	                int val = Integer.parseInt(m.group(1));
	                // If the string contains "hour" consider val * 60
	                if (duration.toLowerCase(Locale.ROOT).contains("hour")) {
	                    return val * 60;
	                } else {
	                    return val;
	                }
	            } catch (NumberFormatException e) {
	                return -1;
	            }
	        }
	        return -1;
	    }

	    private Optional<Integer> extractRequestedDurationFromQuery(String query) {
	        if (query == null || query.isBlank()) return Optional.empty();
	        // Search for durations like "40 minutes", "about an hour", "30-40 mins", "1 hour" in query text
	        Pattern pattern = Pattern.compile("(\\d+)\\s*(?:-\\s*(\\d+))?\\s*(?:minutes|min|hours|hour)");
	        Matcher matcher = pattern.matcher(query.toLowerCase(Locale.ROOT));
	        if (matcher.find()) {
	            try {
	                int start = Integer.parseInt(matcher.group(1));
	                String endGroup = matcher.group(2);
	                int end = endGroup != null ? Integer.parseInt(endGroup) : start;
	                int avg = (start + end) / 2;
	                if (query.toLowerCase(Locale.ROOT).contains("hour")) {
	                    avg = avg * 60;
	                }
	                return Optional.of(avg);
	            } catch (NumberFormatException e) {
	                return Optional.empty();
	            }
	        }
	        // Check for presence of "hour" or "about an hour"
	        if (query.toLowerCase(Locale.ROOT).contains("hour")) {
	            return Optional.of(60);
	        }
	        return Optional.empty();
	    }

	    public List<Assessment> recommendAssessments(String query) {
	        if (query == null || query.isBlank()) {
	            return assessments.stream().limit(10).collect(Collectors.toList());
	        }

	        Set<String> queryKeywords = extractKeywords(query);
	        Optional<Integer> requestedDurationOpt = extractRequestedDurationFromQuery(query);

	        Set<Assessment> matchedAssessments = new HashSet<>();
	        for (String qk : queryKeywords) {
	            Set<Assessment> found = keywordIndex.get(qk);
	            if (found != null) {
	                matchedAssessments.addAll(found);
	            }
	        }

	        // If requested duration exists, filter by duration in ±10 minutes range
	        if (requestedDurationOpt.isPresent()) {
	            int requestedDuration = requestedDurationOpt.get();
	            matchedAssessments = matchedAssessments.stream()
	                    .filter(a -> {
	                        int dur = parseDurationInMinutes(a.getDuration());
	                        return dur != -1 && Math.abs(dur - requestedDuration) <= 10;
	                    })
	                    .collect(Collectors.toSet());
	        }

	        // If no matches after filtering, fallback to filtering only by duration on entire dataset (if duration requested)
	        if (matchedAssessments.isEmpty() && requestedDurationOpt.isPresent()) {
	            int requestedDuration = requestedDurationOpt.get();
	            matchedAssessments = assessments.stream()
	                    .filter(a -> {
	                        int dur = parseDurationInMinutes(a.getDuration());
	                        return dur != -1 && Math.abs(dur - requestedDuration) <= 10;
	                    })
	                    .collect(Collectors.toSet());
	        }

	        // If still no matches fallback to top 10 assessments
	        if (matchedAssessments.isEmpty()) {
	            return assessments.stream().limit(10).collect(Collectors.toList());
	        }

	        // Return up to 10 results, sorted by relevance (closest duration difference, then alphabet)
	        List<Assessment> resultList = new ArrayList<>(matchedAssessments);
	        if (requestedDurationOpt.isPresent()) {
	            int requestedDuration = requestedDurationOpt.get();
	            resultList.sort(Comparator.comparingInt(a -> Math.abs(parseDurationInMinutes(a.getDuration()) - requestedDuration)));
	        } else {
	            resultList.sort(Comparator.comparing(Assessment::getName));
	        }

	        return resultList.stream().limit(10).collect(Collectors.toList());
	    }
}
