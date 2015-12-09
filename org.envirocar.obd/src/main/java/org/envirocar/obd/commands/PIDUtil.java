/**
 * Copyright (C) 2013 - 2015 the enviroCar community
 *
 * This file is part of the enviroCar app.
 *
 * The enviroCar app is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The enviroCar app is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with the enviroCar app. If not, see http://www.gnu.org/licenses/.
 */
package org.envirocar.obd.commands;

import org.envirocar.core.entity.Measurement;
import org.envirocar.obd.commands.request.ModeOneCommand;
import org.envirocar.obd.commands.request.PIDCommand;

public class PIDUtil {

	public static PID fromString(String s) {
		if (s == null || s.isEmpty()) {
			return null;
		}
		
		for (PID p : PID.values()) {
			if (s.equalsIgnoreCase(p.getHexadecimalRepresentation())) {
				return p;
			}
		}
		
		return null;
	}

	
	public static PIDCommand instantiateCommand(String pid) {
		return instantiateCommand(fromString(pid));
	}
	
	public static PIDCommand instantiateCommand(PID pid) {
		switch (pid) {
			case FUEL_SYSTEM_STATUS:
			case CALCULATED_ENGINE_LOAD:
			case FUEL_PRESSURE:
			case INTAKE_MAP:
			case RPM:
			case SPEED:
			case INTAKE_AIR_TEMP:
			case MAF:
			case TPS:
			case O2_LAMBDA_PROBE_1_VOLTAGE:
			case O2_LAMBDA_PROBE_2_VOLTAGE:
			case O2_LAMBDA_PROBE_3_VOLTAGE:
			case O2_LAMBDA_PROBE_4_VOLTAGE:
			case O2_LAMBDA_PROBE_5_VOLTAGE:
			case O2_LAMBDA_PROBE_6_VOLTAGE:
			case O2_LAMBDA_PROBE_7_VOLTAGE:
			case O2_LAMBDA_PROBE_8_VOLTAGE:
				return new ModeOneCommand(pid);
			default:
				return null;
		}
	}

	public static Measurement.PropertyKey toPropertyKey(PID pid) {
		return null;
	}
}
