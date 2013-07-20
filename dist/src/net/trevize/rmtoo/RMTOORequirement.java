package net.trevize.rmtoo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import net.trevize.reqhunter.api.Requirement;
import net.trevize.rmtoo.jaxb.RequirementT;

/**
 * 
 * 
 * @author Nicolas James <nicolas.james@gmail.com> [[http://njames.trevize.net]]
 * Requirement.java - Jun 15, 2011
 */

public class RMTOORequirement extends RequirementT implements Requirement {

	public static final String FIELD_LABEL_ID = "Id";
	public static final String FIELD_LABEL_NAME = "Name";
	public static final String FIELD_LABEL_TYPE = "Type";
	public static final String FIELD_LABEL_INVENTED_ON = "Invented on";
	public static final String FIELD_LABEL_INVENTED_BY = "Invented by";
	public static final String FIELD_LABEL_OWNER = "Owner";
	public static final String FIELD_LABEL_DESCRIPTION = "Description";
	public static final String FIELD_LABEL_RATIONALE = "Rationale";
	public static final String FIELD_LABEL_NOTE = "Note";
	public static final String FIELD_LABEL_SOLVED_BY = "Solved by";
	public static final String FIELD_LABEL_STATUS = "Status";
	public static final String FIELD_LABEL_TOPIC = "Topic";
	public static final String FIELD_LABEL_CLASS = "Class";
	public static final String FIELD_LABEL_PRIORITY = "Priority";
	public static final String FIELD_LABEL_EFFORT_ESTIMATION = "Effort estimation";
	public static final String FIELD_LABEL_CONSTRAINTS = "Constraints";

	public static final String[] FIELD_LABELS = new String[] { FIELD_LABEL_ID,
			FIELD_LABEL_NAME, FIELD_LABEL_TYPE, FIELD_LABEL_INVENTED_ON,
			FIELD_LABEL_INVENTED_BY, FIELD_LABEL_OWNER,
			FIELD_LABEL_DESCRIPTION, FIELD_LABEL_RATIONALE, FIELD_LABEL_NOTE,
			FIELD_LABEL_SOLVED_BY, FIELD_LABEL_STATUS, FIELD_LABEL_TOPIC,
			FIELD_LABEL_CLASS, FIELD_LABEL_PRIORITY,
			FIELD_LABEL_EFFORT_ESTIMATION, FIELD_LABEL_CONSTRAINTS };

	//JAXB objects
	private static JAXBContext jaxb_context;
	private static Marshaller m;
	private static Unmarshaller u;

	public static void initJAXBObjects() {
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

	private ArrayList<String> field_labels;

	public RMTOORequirement() {
		super();
	}

	public RMTOORequirement(RMTOORequirement req) {
		super();
		for (String field_label : getFieldLabels()) {
			setFieldValue(field_label, req.getFieldValue(field_label));
		}
	}

	public String getReference() {
		return getName();
	}

	/***************************************************************************
	 * implementation of Requirement
	 **************************************************************************/

	@Override
	public String getId() {
		return super.getId();
	}

	@Override
	public void setId(String id) {
		super.setId(id);
	}

	@Override
	public ArrayList<String> getFieldLabels() {
		if (field_labels == null) {
			field_labels = new ArrayList<String>();
			for (String field_label : FIELD_LABELS) {
				field_labels.add(field_label);
			}
		}
		return field_labels;
	}

	@Override
	public List<String> getFieldValues() {
		ArrayList<String> field_values_list = new ArrayList<String>();
		for (String field_label : FIELD_LABELS) {
			field_values_list.add(getFieldValue(field_label));
		}
		return field_values_list;
	}

	@Override
	public String getFieldValue(String field_label) {
		if (field_label == FIELD_LABEL_ID) {
			return getId();
		}

		else

		if (field_label == FIELD_LABEL_NAME) {
			return getName();
		}

		else

		if (field_label == FIELD_LABEL_TYPE) {
			return getType();
		}

		else

		if (field_label == FIELD_LABEL_INVENTED_ON) {
			return getInventedOn();
		}

		else

		if (field_label == FIELD_LABEL_INVENTED_BY) {
			return getInventedBy();
		}

		else

		if (field_label == FIELD_LABEL_OWNER) {
			return getOwner();
		}

		else

		if (field_label == FIELD_LABEL_DESCRIPTION) {
			return getDescription();
		}

		else

		if (field_label == FIELD_LABEL_RATIONALE) {
			return getRationale();
		}

		else

		if (field_label == FIELD_LABEL_NOTE) {
			return getNote();
		}

		else

		if (field_label == FIELD_LABEL_SOLVED_BY) {
			return getSolvedBy();
		}

		else

		if (field_label == FIELD_LABEL_STATUS) {
			return getStatus();
		}

		else

		if (field_label == FIELD_LABEL_TOPIC) {
			return getTopic();
		}

		else

		if (field_label == FIELD_LABEL_CLASS) {
			return getClazz();
		}

		else

		if (field_label == FIELD_LABEL_PRIORITY) {
			return getPriority();
		}

		else

		if (field_label == FIELD_LABEL_EFFORT_ESTIMATION) {
			return getEffortEstimation();
		}

		else

		if (field_label == FIELD_LABEL_CONSTRAINTS) {
			return getConstraints();
		}

		return null;
	}

	@Override
	public void setFieldValue(String field_label, String field_value) {
		if (field_label == FIELD_LABEL_ID) {
			setId(field_value);
		}

		else

		if (field_label == FIELD_LABEL_NAME) {
			setName(field_value);
		}

		else

		if (field_label == FIELD_LABEL_TYPE) {
			setType(field_value);
		}

		else

		if (field_label == FIELD_LABEL_INVENTED_ON) {
			setInventedOn(field_value);
		}

		else

		if (field_label == FIELD_LABEL_INVENTED_BY) {
			setInventedBy(field_value);
		}

		else

		if (field_label == FIELD_LABEL_OWNER) {
			setOwner(field_value);
		}

		else

		if (field_label == FIELD_LABEL_DESCRIPTION) {
			setDescription(field_value);
		}

		else

		if (field_label == FIELD_LABEL_RATIONALE) {
			setRationale(field_value);
		}

		else

		if (field_label == FIELD_LABEL_NOTE) {
			setNote(field_value);
		}

		else

		if (field_label == FIELD_LABEL_SOLVED_BY) {
			setSolvedBy(field_value);
		}

		else

		if (field_label == FIELD_LABEL_STATUS) {
			setStatus(field_value);
		}

		else

		if (field_label == FIELD_LABEL_TOPIC) {
			setTopic(field_value);
		}

		else

		if (field_label == FIELD_LABEL_CLASS) {
			setClazz(field_value);
		}

		else

		if (field_label == FIELD_LABEL_PRIORITY) {
			setPriority(field_value);
		}

		else

		if (field_label == FIELD_LABEL_EFFORT_ESTIMATION) {
			setEffortEstimation(field_value);
		}

		else

		if (field_label == FIELD_LABEL_CONSTRAINTS) {
			setConstraints(field_value);
		}
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		for (String field_label : FIELD_LABELS) {
			sb.append(field_label + ": " + getFieldValue(field_label) + "\n");
		}

		return sb.toString();
	}

	@Override
	public int getIndexOfLabel(String field_label) {
		return getFieldLabels().indexOf(field_label);
	}

}
