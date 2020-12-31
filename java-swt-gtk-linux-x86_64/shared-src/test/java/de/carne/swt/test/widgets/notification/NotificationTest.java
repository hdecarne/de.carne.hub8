/*
 * Copyright (c) 2007-2021 Holger de Carne and contributors, All Rights Reserved.
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
package de.carne.swt.test.widgets.notification;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.carne.boot.Application;
import de.carne.swt.test.SWTTestApplication;
import de.carne.test.swt.DisableIfThreadNotSWTCapable;
import de.carne.test.swt.tester.SWTTest;

/**
 * Test {@linkplain de.carne.swt.widgets.notification.Notification} class.
 */
@DisableIfThreadNotSWTCapable
class NotificationTest extends SWTTest {

	@Test
	void testNotification() {
		Script script = script(Application::main);

		script.add(this::doOpenNotification);
		script.add(this::doCloseNotification);
		script.add(this::doClose);
		script.execute();
		Assertions.assertTrue(script.passed());
	}

	private void doOpenNotification() {
		accessShell().accessMenuBar().accessItem(SWTTestApplication.MENU_ITEM_NOTIFICATION).select();
	}

	private void doCloseNotification() {
		accessActiveShell().close();
	}

	private void doClose() {
		accessShell().close();
	}

}
