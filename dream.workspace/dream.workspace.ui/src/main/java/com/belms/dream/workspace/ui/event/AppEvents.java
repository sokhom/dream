/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.ui.event;

import com.belms.dream.workspace.ui.NavigatorViewType;

public abstract class AppEvents {

	public static final class PostViewChangeEvent {
		private final NavigatorViewType view;

		public PostViewChangeEvent(final NavigatorViewType view) {
			this.view = view;
		}

		public NavigatorViewType getView() {
			return view;
		}
	}

	public static class UserLoggedOutEvent {

	}
}
