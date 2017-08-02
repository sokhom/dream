/***
 * @author ngounphanny
 * 
 */
package com.belms.dream.workspace.ui.fragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

import com.belms.dream.api.view.bridge.uifragments.UIFragmentFactory;
import com.belms.dream.api.view.bridge.uifragments.UIFragmentInfo;
import com.belms.dream.api.view.bridge.uifragments.UIFragmentInfo.VIEW_LEVEL;
import com.belms.dream.api.view.event.EventBusProvider;
import com.belms.dream.workspace.ui.NavigatorViewType;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class UIFragmentProvider implements Serializable{

	private static final long serialVersionUID = 1L;
	private static Map<String, UIFragmentFactory> map = new HashMap<>();
	private static Map<String, NavigatorViewType> navigatorViewTyes = new HashMap<>();
	private static List<NavigatorViewType> navigatorViewTypes;
	private static boolean spi = true;

	private UIFragmentProvider() {
	}

	public static void add(UIFragmentFactory uiFragmentFactory) {
		if (!map.containsKey(uiFragmentFactory.getUIFagmentInfo().getId())) {
			map.put(uiFragmentFactory.getUIFagmentInfo().getId(), uiFragmentFactory);
		}

	}

	public static void remove(UIFragmentFactory uiFragmentFactory) {
		map.remove(uiFragmentFactory.getUIFagmentInfo().getId());
	}

	public static List<NavigatorViewType> getMainMenu() {

		if (navigatorViewTypes == null) {
			navigatorViewTypes = new ArrayList<>();
			NavigatorViewType navigatorViewType;
			for (UIFragmentFactory fragmentFactory : map.values()) {

				if (fragmentFactory.getUIFagmentInfo().isNavigate()
						&& fragmentFactory.getUIFagmentInfo().getViewLevel() == VIEW_LEVEL.LEVEL1) {

					navigatorViewTypes.add(navigatorViewType = new NavigatorViewType(fragmentFactory.getUIFagmentInfo().getId(),
									fragmentFactory.getUIFagmentInfo().getNavigateName(), fragmentFactory,
									fragmentFactory.getUIFagmentInfo().getIcon(),
									fragmentFactory.getUIFagmentInfo().isStateFull(),
									fragmentFactory.getUIFagmentInfo().isDefaultView()));
					navigatorViewTyes.put(navigatorViewType.getViewName(), navigatorViewType);
				}
			}
		}
		return navigatorViewTypes;
	}

	public static NavigatorViewType geNavigatorViewType(String viewName) {
		return navigatorViewTyes.get(viewName);
	}

	public static List<NavigatorViewType> getNavigatorTypes() {
		return getMainMenu();
	}

	public static void init() {
		if (spi) {

			add(new UIFragmentFactory() {

				@Override
				public UIFragmentInfo getUIFagmentInfo() {
					UIFragmentInfo fragmentInfo = new UIFragmentInfo();
					fragmentInfo.setIcon(VaadinIcons.HOME);
					fragmentInfo.setId("home");
					fragmentInfo.setName("main");
					fragmentInfo.setViewLevel(VIEW_LEVEL.LEVEL1);
					fragmentInfo.setNavigateName("main");
					fragmentInfo.setAccessCode("0001");
					fragmentInfo.setDisplaySeq(1);
					fragmentInfo.setNavigate(true);
					fragmentInfo.setDefaultView(true);
					return fragmentInfo;
				}

				@Override
				public Component getFragment(EventBusProvider eventBusProvider) {

					VerticalLayout layout = new VerticalLayout(new Label("test"));
					return layout;
				}
			});

			ServiceLoader<UIFragmentFactory> loader = ServiceLoader.load(UIFragmentFactory.class);

			Iterator<UIFragmentFactory> uiFactorys = loader.iterator();
			while (uiFactorys.hasNext()) {
				UIFragmentFactory uiFragmentFactory = (UIFragmentFactory) uiFactorys.next();
				add(uiFragmentFactory);
			}
		}
	}

}
