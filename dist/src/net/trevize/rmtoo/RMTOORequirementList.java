package net.trevize.rmtoo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

import net.trevize.reqhunter.api.Requirement;
import net.trevize.reqhunter.api.RequirementList;
import net.trevize.rmtoo.jaxb.ObjectFactory;
import net.trevize.rmtoo.jaxb.RequirementT;
import net.trevize.rmtoo.jaxb.RequirementsT;

public class RMTOORequirementList implements RequirementList {

	public static class ComparatorIdAsIntegerValue implements
			Comparator<Requirement> {
		@Override
		public int compare(Requirement o1, Requirement o2) {
			Integer v1 = Integer.parseInt(o1
					.getFieldValue(RMTOORequirement.FIELD_LABEL_ID));
			Integer v2 = Integer.parseInt(o2
					.getFieldValue(RMTOORequirement.FIELD_LABEL_ID));
			return v1.compareTo(v2);
		}
	}

	public static class ComparatorIdAsString implements Comparator<Requirement> {
		@Override
		public int compare(Requirement o1, Requirement o2) {
			return o1.getFieldValue(RMTOORequirement.FIELD_LABEL_ID).compareTo(
					o2.getFieldValue(RMTOORequirement.FIELD_LABEL_ID));
		}
	}

	private RMTOORequirementFactory requirement_factory;
	private List<Requirement> requirements;
	private JAXBContext jaxb_context;
	private Marshaller m;
	private Unmarshaller u;
	private RequirementsT requirements_t;

	public RMTOORequirementList() {
		requirement_factory = new RMTOORequirementFactory();
		initJAXBObjects();
		requirements = new ArrayList<Requirement>();
	}

	private void initJAXBObjects() {
		try {
			jaxb_context = JAXBContext.newInstance("net.trevize.rmtoo.jaxb");

			m = jaxb_context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			u = jaxb_context.createUnmarshaller();
			u.setProperty("com.sun.xml.internal.bind.ObjectFactory",
					new RMTOORequirementFactory());
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	/***************************************************************************
	 * implementation of RequirementList
	 **************************************************************************/

	@Override
	public String getFreeID() {
		int highest_id_num = -1;
		for (int i = 0; i < requirements.size(); ++i) {
			RMTOORequirement req = (RMTOORequirement) requirements.get(i);
			int id_num = Integer.parseInt(req.getId());
			if (id_num > highest_id_num) {
				highest_id_num = id_num;
			}
		}
		return "" + (highest_id_num + 1);
	}

	@Override
	public List<Requirement> getRequirements() {
		return requirements;
	}

	@Override
	public Requirement insertNewRequirement() {
		Requirement req = requirement_factory.createRequirement();
		req.setFieldValue(RMTOORequirement.FIELD_LABEL_ID, getFreeID());
		return req;
	}

	@Override
	public synchronized void loadRequirements(String requirements_file_path) {
		JAXBElement<RequirementsT> jaxbelmt = null;
		try {
			jaxbelmt = (JAXBElement<RequirementsT>) u
					.unmarshal(new FileInputStream(requirements_file_path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			System.err.println("Error while parsing the file "
					+ requirements_file_path);
			e.printStackTrace();
		}

		requirements_t = jaxbelmt.getValue();

		for (RequirementT req_t : requirements_t.getRequirement()) {
			requirements.add((RMTOORequirement) req_t);
		}

		System.out.println("Loaded " + requirements.size() + " requirements.");
	}

	@Override
	public synchronized void writeRequirements(String requirements_file_path) {
		if (requirements_t == null) {
			requirements_t = new ObjectFactory().createRequirementsT();
		}

		requirements_t.getRequirement().clear();
		for (Requirement req : requirements) {
			requirements_t.getRequirement().add((RMTOORequirement) req);
		}

		try {
			FileOutputStream fos = new FileOutputStream(requirements_file_path);
			m.marshal(new JAXBElement<RequirementsT>(new QName(
					"http://trevize.net/RMTOO", "requirements"),
					RequirementsT.class, requirements_t), fos);
		} catch (PropertyException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
