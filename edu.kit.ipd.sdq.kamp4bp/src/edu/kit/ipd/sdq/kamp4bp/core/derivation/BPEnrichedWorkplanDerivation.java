package edu.kit.ipd.sdq.kamp4bp.core.derivation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.palladiosimulator.pcm.core.entity.NamedElement;
import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;

import edu.kit.ipd.sdq.kamp.workplan.Activity;
import edu.kit.ipd.sdq.kamp.workplan.BasicActivity;
import edu.kit.ipd.sdq.kamp4bp.core.BPActivityElementType;
import edu.kit.ipd.sdq.kamp4bp.core.BPActivityType;
import edu.kit.ipd.sdq.kamp4bp.core.BPArchitectureVersion;
import edu.kit.ipd.sdq.kamp4bp.core.BPArchitecureAnnotationLookup;
import edu.kit.ipd.sdq.kamp4is.core.derivation.AbstractISEnrichedWorkplanDerivation;
import edu.kit.ipd.sdq.kamp4is.core.derivation.ISSubactivityDerivation;
import edu.kit.ipd.sdq.kamp4bp.model.fieldofactivityannotations.BPFieldOfActivityAnnotationsRepository;
import edu.kit.ipd.sdq.kamp4bp.model.fieldofactivityannotations.BPUserActionAnnotation;

public class BPEnrichedWorkplanDerivation extends AbstractISEnrichedWorkplanDerivation<BPArchitectureVersion> {

	public static Activity addBusinessProcessFollowupActivity(NamedElement entity, 
			NamedElement parentElement, Activity parentActivity) {
		Activity result = new Activity(BPActivityType.BUSINESS_PROCESS, 
				BPActivityElementType.getAnnotationActivityTypeForObject(entity), 
				entity, entity.getEntityName(), null, parentActivity.getBasicActivity(), 
				ISSubactivityDerivation.generateDescription(parentElement, entity, 
					parentActivity.getBasicActivity()));
		parentActivity.addFollowupActivity(result);
		return result;
	}
	
	private static BPFieldOfActivityAnnotationsRepository determineRelevantBPAnnotationRepository(
			Activity activity, BPArchitectureVersion baseVersion, BPArchitectureVersion targetVersion) {
		if (activity.getBasicActivity() == BasicActivity.REMOVE) {
			if (baseVersion.getFieldOfActivityRepository() instanceof BPFieldOfActivityAnnotationsRepository) {
				return (BPFieldOfActivityAnnotationsRepository) baseVersion.getFieldOfActivityRepository();
			} else {
				return null;
			}
		} else {
			if (targetVersion.getFieldOfActivityRepository() instanceof BPFieldOfActivityAnnotationsRepository) {
				return (BPFieldOfActivityAnnotationsRepository) targetVersion.getFieldOfActivityRepository();
			} else {
				return null;
			}
		}
	}
	
	@Override
	public List<Activity> deriveEnrichedWorkplan(BPArchitectureVersion baseVersion,
			BPArchitectureVersion targetVersion, List<Activity> baseActivityList) {
		List<Activity> result = new ArrayList<Activity>(super.deriveEnrichedWorkplan(
				baseVersion, targetVersion, baseActivityList));
		
		deriveBPUserActionAnnotationActivities(baseVersion, targetVersion, result);
		
		return result;
	}
	
	private static void deriveBPUserActionAnnotationActivities(BPArchitectureVersion baseVersion,
			BPArchitectureVersion targetVersion, List<Activity> activityList) {
		for (Activity activity: activityList) {
			if (activity.getElement() instanceof AbstractUserAction) {
				AbstractUserAction userAction = (AbstractUserAction) activity.getElement();
				BPFieldOfActivityAnnotationsRepository annotationRepository = 
						determineRelevantBPAnnotationRepository(activity, baseVersion, targetVersion);
				if (annotationRepository != null) {
					Collection<BPUserActionAnnotation<?>> userActionAnnotations = BPArchitecureAnnotationLookup.
							lookUpUserActionAnnotationsForUserAction(annotationRepository, userAction);
					for (BPUserActionAnnotation<?> userActionAnnotation: userActionAnnotations) {
						addBusinessProcessFollowupActivity(userActionAnnotation, userAction, activity);
					}
				}
			}
		}
	}
	
}
