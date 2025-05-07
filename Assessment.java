package SHL.Assessment.Recommend.model;

public class Assessment {
	 	private String name;
	    public Assessment(String name, String url, String remoteTestingSupport, String adaptiveIrtSupport,
				String duration, String testType) {
			super();
			this.name = name;
			this.url = url;
			this.remoteTestingSupport = remoteTestingSupport;
			this.adaptiveIrtSupport = adaptiveIrtSupport;
			this.duration = duration;
			this.testType = testType;
		}
		public String getName() {
			return name;
		}
		@Override
		public String toString() {
			return "Assessment [name=" + name + ", url=" + url + ", remoteTestingSupport=" + remoteTestingSupport
					+ ", adaptiveIrtSupport=" + adaptiveIrtSupport + ", duration=" + duration + ", testType=" + testType
					+ "]";
		}
		public Assessment() {
			super();
			// TODO Auto-generated constructor stub
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getRemoteTestingSupport() {
			return remoteTestingSupport;
		}
		public void setRemoteTestingSupport(String remoteTestingSupport) {
			this.remoteTestingSupport = remoteTestingSupport;
		}
		public String getAdaptiveIrtSupport() {
			return adaptiveIrtSupport;
		}
		public void setAdaptiveIrtSupport(String adaptiveIrtSupport) {
			this.adaptiveIrtSupport = adaptiveIrtSupport;
		}
		public String getDuration() {
			return duration;
		}
		public void setDuration(String duration) {
			this.duration = duration;
		}
		public String getTestType() {
			return testType;
		}
		public void setTestType(String testType) {
			this.testType = testType;
		}
		private String url;
	    private String remoteTestingSupport;
	    private String adaptiveIrtSupport;
	    private String duration;
	    private String testType;

}
