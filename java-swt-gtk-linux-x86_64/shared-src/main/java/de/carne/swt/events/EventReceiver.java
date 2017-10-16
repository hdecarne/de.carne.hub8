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
package de.carne.swt.events;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import de.carne.check.Nullable;

/**
 * Event listener for mapping a SWT event to a receiving action.
 */
public class EventReceiver implements Listener {

	private final Runnable receiver;

	private EventReceiver(Runnable receiver) {
		this.receiver = receiver;
	}

	/**
	 * {@linkplain Event} receiver.
	 *
	 * @param receiver The receiving action.
	 * @return The event listener.
	 */
	public static EventReceiver any(Runnable receiver) {
		return new EventReceiver(receiver);
	}

	@Override
	public void handleEvent(@Nullable Event event) {
		this.receiver.run();
	}

}