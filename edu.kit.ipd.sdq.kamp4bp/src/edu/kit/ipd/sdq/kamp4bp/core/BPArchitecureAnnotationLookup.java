package edu.kit.ipd.sdq.kamp4bp.core;

import java.util.Collection;
import java.util.LinkedList;

import org.palladiosimulator.pcm.usagemodel.AbstractUserAction;

import edu.kit.ipd.sdq.kamp4bp.model.fieldofactivityannotations.BPFieldOfActivityAnnotationsRepository;
import edu.kit.ipd.sdq.kamp4bp.model.fieldofactivityannotations.BPUserActionAnnotation;

public class BPArchitecureAnnotationLookup {

	public static Collection<BPUserActionAnnotation<?>> lookUpUserActionAnnotationsForUserAction(
			BPFieldOfActivityAnnotationsRepository annotationRepository, 
			AbstractUserAction userAction) {
		Collection<BPUserActionAnnotation<?>> results = new LinkedList<BPUserActionAnnotation<?>>();

		if (annotationRepository.getBusinessProcessSpecification() != null) {
			for (BPUserActionAnnotation<?> userActionAnnotation: annotationRepository.
					getBusinessProcessSpecification().getUserActionAnnotations()) {
				if (userActionAnnotation.getAnnotatedUserActions().contains(userAction)) {
					results.add(userActionAnnotation);
				}
			}
		}		
		
		return results;
	}
	
}
