package lu.cronos._03_time_based_versionning;

import java.lang.Runtime.Version;

public class JavaTimeBasedVersioning {

	public static void main(String[] args) {
		
		// The new pattern of the Version number is:
        // $FEATURE.$INTERIM.$UPDATE.$PATCH
		
		// $FEATURE: counter will be incremented every 6 months and will be based 
		//           on feature release versions, e.g: JDK 10, JDK 11.

        // $INTERIM: counter will be incremented for non-feature releases that contain 
		//           compatible bug fixes and enhancements but no incompatible changes. 
		//           Usually, this will be zero, as there will be no interim release in 
		//           a six month period. This kept for a future revision to the release model.

        // $UPDATE: counter will be incremented for compatible update releases that fix security issues, 
		//          regressions, and bugs in newer features. This is updated one month after the feature release and every 3 months thereafter.
		
        // $PATCH: counter will be incremented for an emergency release to fix a critical issue.
		
		Version version = Runtime.version();
		var feature = version.feature();
		var interim = version.interim();
		var update= version.update();
		var patch = version.patch();
		
		System.out.println("The current JRE running version is : "+feature+ "."+interim+ "-"+update+"."+patch);

	}
}
