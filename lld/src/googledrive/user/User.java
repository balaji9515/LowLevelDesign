package googledrive.user;

public class User 
{
	private String userName;
	private String password;
	private Role role;
	public User(String userName, String password, Role role) 
	{
		
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	public String getUserName() 
	{
		return userName;
	}
	public Role getRole()
	{
		return role;
	}
	
	public boolean authenticate(String password)
	{
		return this.password.equals(password);
	}
	
	
	

}
