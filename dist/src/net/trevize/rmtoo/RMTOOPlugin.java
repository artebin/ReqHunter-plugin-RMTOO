package net.trevize.rmtoo;

import net.trevize.reqhunter.plugins.ReqHunterPlugin;
import net.trevize.reqhunter.plugins.ReqHunterPluginType;

import org.java.plugin.Plugin;

public class RMTOOPlugin extends Plugin implements ReqHunterPlugin {

	/***************************************************************************
	 * implementation of ReqHunterPlugin
	 **************************************************************************/

	@Override
	public String getPluginName() {
		return "RMTOO-ReqHunter-Binding";
	}

	@Override
	public String getPluginType() {
		return ReqHunterPluginType.REQHUNTER_PLUGIN_TYPE_REQUIREMENT_BINDING;
	}

	@Override
	public String getFactoryName() {
		return RMTOORequirementFactory.class.getCanonicalName();
	}

	/***************************************************************************
	 * implementation of Plugin
	 **************************************************************************/

	@Override
	protected void doStart() throws Exception {
	}

	@Override
	protected void doStop() throws Exception {
	}

}
