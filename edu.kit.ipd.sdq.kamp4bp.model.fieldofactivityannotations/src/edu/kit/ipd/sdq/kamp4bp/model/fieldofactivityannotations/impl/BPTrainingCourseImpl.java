/**
 */
package edu.kit.ipd.sdq.kamp4bp.model.fieldofactivityannotations.impl;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.ActorStep;

import edu.kit.ipd.sdq.kamp4bp.model.fieldofactivityannotations.BPFieldOfActivityAnnotationsPackage;
import edu.kit.ipd.sdq.kamp4bp.model.fieldofactivityannotations.BPTrainingCourse;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BP Training Course</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class BPTrainingCourseImpl extends BPUserActionAnnotationImpl<ActorStep> implements BPTrainingCourse {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BPTrainingCourseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPFieldOfActivityAnnotationsPackage.Literals.BP_TRAINING_COURSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific element type known in this context.
	 * @generated
	 */
	@Override
	public EList<ActorStep> getAnnotatedUserActions() {
		if (annotatedUserActions == null) {
			annotatedUserActions = new EObjectResolvingEList<ActorStep>(ActorStep.class, this, BPFieldOfActivityAnnotationsPackage.BP_TRAINING_COURSE__ANNOTATED_USER_ACTIONS);
		}
		return annotatedUserActions;
	}

} //BPTrainingCourseImpl
