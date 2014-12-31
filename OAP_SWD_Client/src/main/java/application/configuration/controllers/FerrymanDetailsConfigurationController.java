package application.configuration.controllers;

import application.mode.Mode;
import facade.interfaces.dts.FerrymanDts;

public class FerrymanDetailsConfigurationController {
	private final FerrymanDts ferryman;
	private final Mode mode;

	public FerrymanDetailsConfigurationController(FerrymanDts ferryman,
			Mode mode) {
		this.ferryman = ferryman;
		if (mode == null) {
			this.mode = Mode.CREATE;
		} else {
			this.mode = mode;
		}

	}

	public FerrymanDts getFerryman() {
		return ferryman;
	}

	public Mode getMode() {
		return mode;
	}
}
