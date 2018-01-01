/*
 * Copyright (c) 2017-2018 Holger de Carne and contributors, All Rights Reserved.
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
package de.carne.test.swt.tester;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.MenuItem;

/**
 * Class providing access to the application's {@linkplain MenuItem} objects.
 */
public class MenuItemAccessor extends Accessor<MenuItem> {

	/**
	 * Construct {@linkplain MenuItemAccessor}.
	 *
	 * @param menuItem The {@linkplain MenuItem} object to wrap.
	 */
	public MenuItemAccessor(MenuItem menuItem) {
		super(menuItem);
	}

	/**
	 * Generate a selection event to the {@linkplain MenuItem}.
	 */
	public void select() {
		get().notifyListeners(SWT.Selection, new Event());
	}

}
