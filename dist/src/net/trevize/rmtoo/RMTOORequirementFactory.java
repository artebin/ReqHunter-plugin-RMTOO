package net.trevize.rmtoo;

import javax.xml.bind.annotation.XmlRegistry;

import net.trevize.reqhunter.api.Requirement;
import net.trevize.reqhunter.api.RequirementFactory;
import net.trevize.reqhunter.api.RequirementList;
import net.trevize.rmtoo.jaxb.ObjectFactory;
import net.trevize.rmtoo.jaxb.RequirementT;
import net.trevize.rmtoo.jaxb.RequirementsT;

@XmlRegistry
public class RMTOORequirementFactory extends ObjectFactory implements
		RequirementFactory {

	/***************************************************************************
	 * implementation of ObjectFactory
	 **************************************************************************/

	@Override
	public RequirementT createRequirementT() {
		return new RMTOORequirement();
	}

	@Override
	public RequirementsT createRequirementsT() {
		return new RequirementsT();
	}

	/***************************************************************************
	 * implementation of RequirementFactory
	 **************************************************************************/

	@Override
	public Requirement createRequirement() {
		return new RMTOORequirement();
	}

	@Override
	public RequirementList createRequirementList() {
		return new RMTOORequirementList();
	}



}
