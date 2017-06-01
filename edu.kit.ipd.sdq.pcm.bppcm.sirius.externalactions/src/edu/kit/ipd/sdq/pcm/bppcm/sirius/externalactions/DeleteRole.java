package edu.kit.ipd.sdq.pcm.bppcm.sirius.externalactions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DEdgeSpec;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DNodeSpec;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;

import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.ActorResource;
import de.uhd.ifi.se.pcm.bppcm.organizationenvironmentmodel.Role;

public class DeleteRole implements IExternalJavaAction {

	public DeleteRole() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(Collection<? extends EObject> selections, Map<String, Object> parameters) {
		for (EObject eObject : selections) {
			if(eObject instanceof ActorResource) {
				List<String> selectedRoleEdges = new ArrayList<String>();
				for (Entry<String, Object> entry : parameters.entrySet()) {
					System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue() + ", Type = " + entry.getValue().getClass().getName());
					if (!(entry.getValue() instanceof DEdgeSpec))
						return;
					DEdgeSpec roleEdge = (DEdgeSpec) entry.getValue();
					DNodeSpec dre = (DNodeSpec) roleEdge.getTargetNode();
					selectedRoleEdges.add(dre.getName());
				} 
				
				ActorResource actor = (ActorResource) eObject;
					for (String selectedRoleEdge : selectedRoleEdges) {
						Iterator<Role> it = actor.getRoles().iterator();
						while (it.hasNext()) {
							Role role = it.next();
							if (role.getEntityName().equals(selectedRoleEdge))
								it.remove();
							
						}
					}
			}
		}

	}

	@Override
	public boolean canExecute(Collection<? extends EObject> selections) {
		return true;
	}

}
