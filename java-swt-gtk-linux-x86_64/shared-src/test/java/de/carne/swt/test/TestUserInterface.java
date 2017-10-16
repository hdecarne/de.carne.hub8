/*
 * Copyright (c) 2007-2017 Holger de Carne and contributors, All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.carne.swt.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;

import de.carne.swt.ResourceException;
import de.carne.swt.graphics.ImageResourcePool;
import de.carne.swt.widgets.MenuBuilder;
import de.carne.swt.widgets.UserInterface;
import de.carne.util.Late;

/**
 * Test user interface.
 */
public class TestUserInterface extends UserInterface<Shell> {

	private final Late<ImageResourcePool> images = new Late<>();

	@Override
	protected void build(Shell root) throws ResourceException {
		this.images.set(new ImageResourcePool(root.getDisplay()));
		root.setImages(this.images.get().getAll(Images.class, Images.IMAGES_A));
		root.setText(getClass().getTypeName());

		TestUserAgent agent = new TestUserAgent();

		buildMenuBar(root, agent);
	}

	private void buildMenuBar(Shell root, TestUserAgent agent) throws ResourceException {
		MenuBuilder menu = MenuBuilder.menuBar(root);
		Image itemImage = this.images.get().get(Images.class, Images.IMAGE_A_16);

		menu.addItem(SWT.CASCADE).withText("Menu A");
		menu.beginMenu();
		menu.addItem(SWT.PUSH).withText("Menu item A.1").withImage(itemImage);
		menu.onSelected(agent::onMenuItemSelected);
		menu.addItem(SWT.PUSH).withText("Menu item A.2").withImage(itemImage);
		menu.onSelected(agent::onMenuItemSelected);
		menu.endMenu();
		menu.addItem(SWT.CASCADE).withText("Menu B");
		menu.beginMenu();
		menu.addItem(SWT.PUSH).withText("Menu item B.1").withImage(itemImage);
		menu.onSelected(agent::onMenuItemSelected);
		menu.addItem(SWT.PUSH).withText("Menu item B.2").withImage(itemImage);
		menu.onSelected(agent::onMenuItemSelected);
		menu.endMenu();
	}

}
