package test;

public class LoginBean {
	private String id;
		private String pw;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPw() {
			return pw;
		}
		public void setPw(String pw) {
			this.pw = pw;
		}
		
		final String adminId="admin";	// DB가 될 부분
		final String adminPw="1234";	// DB가 될 부분
		
		public boolean login() {
			if(id.equals("") && pw.equals("")) {
				return true;
			}
			return false;
		}
}
