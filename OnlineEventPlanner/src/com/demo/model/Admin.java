package com.demo.model;

public class Admin {
	   private int adminId;
	    private String username;
	    private String fullName;
	    private String password;
	    private String email;
	    private String mobile;
	    
	    
	    
		public Admin() {
			super();
		}
		public Admin(int adminId, String username, String fullName, String password, String email, String mobile) {
			super();
			this.adminId = adminId;
			this.username = username;
			this.fullName = fullName;
			this.password = password;
			this.email = email;
			this.mobile = mobile;
		}
		@Override
		public String toString() {
			return "Admin [adminId=" + adminId + ", username=" + username + ", fullName=" + fullName + ", password="
					+ password + ", email=" + email + ", mobile=" + mobile + "]";
		}
		public int getAdminId() {
			return adminId;
		}
		public void setAdminId(int adminId) {
			this.adminId = adminId;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getFullName() {
			return fullName;
		}
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
	    
	    
	    
}
