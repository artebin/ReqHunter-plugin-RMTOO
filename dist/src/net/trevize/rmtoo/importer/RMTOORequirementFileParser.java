package net.trevize.rmtoo.importer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import net.trevize.rmtoo.RMTOORequirement;

public class RMTOORequirementFileParser {

	public static RMTOORequirement parse(String requirement_file_path) {
		FileReader fr = null;
		try {
			fr = new FileReader(requirement_file_path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);

		RMTOORequirement requirement = new RMTOORequirement();

		try {
			String line = null;
			while (line != null || (line = br.readLine()) != null) {
				String field_label = null;

				if (line.startsWith(RMTOORequirement.FIELD_LABEL_NAME)) {
					field_label = RMTOORequirement.FIELD_LABEL_NAME;
				}

				else

				if (line.startsWith(RMTOORequirement.FIELD_LABEL_TYPE)) {
					field_label = RMTOORequirement.FIELD_LABEL_TYPE;
				}

				else if (line
						.startsWith(RMTOORequirement.FIELD_LABEL_INVENTED_ON)) {
					field_label = RMTOORequirement.FIELD_LABEL_INVENTED_ON;
				}

				else if (line
						.startsWith(RMTOORequirement.FIELD_LABEL_INVENTED_BY)) {
					field_label = RMTOORequirement.FIELD_LABEL_INVENTED_BY;
				}

				else if (line.startsWith(RMTOORequirement.FIELD_LABEL_OWNER)) {
					field_label = RMTOORequirement.FIELD_LABEL_OWNER;
				}

				else if (line
						.startsWith(RMTOORequirement.FIELD_LABEL_DESCRIPTION)) {
					field_label = RMTOORequirement.FIELD_LABEL_DESCRIPTION;
				}

				else if (line
						.startsWith(RMTOORequirement.FIELD_LABEL_RATIONALE)) {
					field_label = RMTOORequirement.FIELD_LABEL_RATIONALE;
				}

				else if (line.startsWith(RMTOORequirement.FIELD_LABEL_NOTE)) {
					field_label = RMTOORequirement.FIELD_LABEL_NOTE;
				}

				else if (line
						.startsWith(RMTOORequirement.FIELD_LABEL_SOLVED_BY)) {
					field_label = RMTOORequirement.FIELD_LABEL_SOLVED_BY;
				}

				else if (line.startsWith(RMTOORequirement.FIELD_LABEL_STATUS)) {
					field_label = RMTOORequirement.FIELD_LABEL_STATUS;
				}

				else if (line.startsWith(RMTOORequirement.FIELD_LABEL_TOPIC)) {
					field_label = RMTOORequirement.FIELD_LABEL_TOPIC;
				}

				else if (line.startsWith(RMTOORequirement.FIELD_LABEL_CLASS)) {
					field_label = RMTOORequirement.FIELD_LABEL_CLASS;
				}

				else if (line.startsWith(RMTOORequirement.FIELD_LABEL_PRIORITY)) {
					field_label = RMTOORequirement.FIELD_LABEL_PRIORITY;
				}

				else if (line
						.startsWith(RMTOORequirement.FIELD_LABEL_EFFORT_ESTIMATION)) {
					field_label = RMTOORequirement.FIELD_LABEL_EFFORT_ESTIMATION;
				}

				else if (line
						.startsWith(RMTOORequirement.FIELD_LABEL_CONSTRAINTS)) {
					field_label = RMTOORequirement.FIELD_LABEL_CONSTRAINTS;
				}

				if (field_label != null) {
					StringBuffer sb = new StringBuffer();
					sb.append(line.substring(field_label.length() + 2,
							line.length()));

					String subline;
					while ((subline = br.readLine()) != null
							&& subline.startsWith(" ")) {
						sb.append(subline);
					}
					if (subline != null) {
						line = subline;
					} else {
						line = null;
					}
					requirement.setFieldValue(field_label, sb.toString());
				} else {
					line = null;
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return requirement;
	}

}
