/**
 */
package edu.kit.ipd.sdq.kamp4bp.model.fieldofactivityannotations.impl;

import de.uhd.ifi.se.pcm.bppcm.bpusagemodel.Activity;

import edu.kit.ipd.sdq.kamp4bp.model.fieldofactivityannotations.BPFieldOfActivityAnnotationsPackage;
import edu.kit.ipd.sdq.kamp4bp.model.fieldofactivityannotations.BPOrganizationalUnit;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BP Organizational Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class BPOrganizationalUnitImpl extends BPUserActionAnnotationImpl<Activity> implements BPOrganizationalUnit {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BPOrganizationalUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPFieldOfActivityAnnotationsPackage.Literals.BP_ORGANIZATIONAL_UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific element type known in this context.
	 * @generated
	 */
	@Override
	public EList<Activity> getAnnotatedUserActions() {
		if (annotatedUserActions == null) {
			annotatedUserActions = new EObjectResolvingEList<Activity>(Activity.class, this, BPFieldOfActivityAnnotationsPackage.BP_ORGANIZATIONAL_UNIT__ANNOTATED_USER_ACTIONS);
		}
		return annotatedUserActions;
	}

} //BPOrganizationalUnitImpl
