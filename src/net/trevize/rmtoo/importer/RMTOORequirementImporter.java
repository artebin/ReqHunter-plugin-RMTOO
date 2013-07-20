package net.trevize.rmtoo.importer;

import java.io.File;

import net.trevize.rmtoo.RMTOORequirement;
import net.trevize.rmtoo.RMTOORequirementList;

public class RMTOORequirementImporter {

	public static void main(String[] args) {
		//import the requirements in memory.
		RMTOORequirementList requirement_list = RMTOORequirementImporter
				.importRequirements(RMTOO_REQ_IMPORT_FOLDER);

		//write the requirements.
		requirement_list.writeRequirements(RMTOO_REQUIREMENTS_FILE_PATH);
	}

	public static final String RMTOO_REQ_IMPORT_FOLDER = "./rmtoo/inputs/rmtoo-requirements";
	public static final String REQUIREMENT_FILENAME_SUFFIX = ".req";
	public static final String RMTOO_REQUIREMENTS_FILE_PATH = "./rmtoo/requirements/requirements.xml";

	public static RMTOORequirementList importRequirements(String folder_path) {
		File[] requirement_files = new File(folder_path).listFiles();
		RMTOORequirementList requirement_list = new RMTOORequirementList();

		int id = 0;
		for (File f : requirement_files) {
			if (!f.getName().endsWith(REQUIREMENT_FILENAME_SUFFIX)) {
				continue;
			}

			RMTOORequirement req = RMTOORequirementFileParser.parse(f
					.getAbsolutePath());
			req.setId("" + (id++));
			requirement_list.getRequirements().add(req);
		}

		return requirement_list;
	}

}
