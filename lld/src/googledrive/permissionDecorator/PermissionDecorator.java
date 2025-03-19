package googledrive.permissionDecorator;

import java.util.HashMap;

import googledrive.user.User;

public class PermissionDecorator
{
	
	
     private HashMap<User,Permissions>userPerm;

	public PermissionDecorator() 
	{

		this.userPerm = new HashMap<User, Permissions>();
	}
     
     
     
    public void setPermission(User user,Permissions permission)
    {
    	userPerm.put(user, permission);
    }
    
    public Permissions getUserPermission(User user)
    {
    	return userPerm.getOrDefault(user,Permissions.NONE);
    }

}
