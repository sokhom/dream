/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.ui.authentication;

import java.io.Serializable;

public interface AccessControl extends Serializable {
	public boolean signIn(String username, String password);

	public boolean isUserSignedIn();

	public boolean isUserInRole(String role);

	public String getPrincipalName();

}
