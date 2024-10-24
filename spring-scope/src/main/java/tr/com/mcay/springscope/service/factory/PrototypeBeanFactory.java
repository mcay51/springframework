package tr.com.mcay.springscope.service.factory;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Service;
import tr.com.mcay.springscope.service.PrototypeBean;

// PrototypeBean örneğini sağlayan factory
@Service
public class PrototypeBeanFactory {

    private ObjectFactory<PrototypeBean> prototypeBeanObjectFactory;

    public PrototypeBeanFactory(ObjectFactory<PrototypeBean> prototypeBeanObjectFactory) {
        this.prototypeBeanObjectFactory = prototypeBeanObjectFactory;
    }

    public PrototypeBean getPrototypeBean() {
        return prototypeBeanObjectFactory.getObject();
    }
}
