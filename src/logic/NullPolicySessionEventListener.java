package logic;


import org.eclipse.persistence.descriptors.ClassDescriptor;
import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.oxm.mappings.XMLDirectMapping;
import org.eclipse.persistence.oxm.mappings.nullpolicy.XMLNullRepresentationType;
import org.eclipse.persistence.sessions.*;

public class NullPolicySessionEventListener extends SessionEventAdapter {

	@Override
    public void preLogin(SessionEvent event) {
        Project project = event.getSession().getProject();
        for(ClassDescriptor descriptor : project.getOrderedDescriptors()) {
            for(DatabaseMapping mapping : descriptor.getMappings()) {
                if(mapping.isAbstractDirectMapping()) {
                    XMLDirectMapping xmlDirectMapping = (XMLDirectMapping) mapping;
                    xmlDirectMapping.getNullPolicy().setMarshalNullRepresentation(XMLNullRepresentationType.EMPTY_NODE);
                    xmlDirectMapping.getNullPolicy().setNullRepresentedByEmptyNode(true);
                }
            }
        }
     }
	
}
