package org.apache.sling.contrib.pipes;

import org.apache.sling.contrib.pipes.dummies.Dummy;
import org.apache.sling.contrib.pipes.dummies.DummySearch;
import org.apache.sling.contrib.pipes.impl.PlumberImpl;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.apache.sling.testing.mock.sling.junit.SlingContext;
import org.junit.Before;
import org.junit.Rule;

/**
 * @todo add license & javadoc :-)
 */
public class AbstractPipeTest {

    protected static final String PATH_PIPE = "/etc/pipe";
    protected static final String PATH_FRUITS = "/content/fruits";
    protected static final String NN_SIMPLE = "simple";
    Plumber plumber;

    @Rule
    public SlingContext context = new SlingContext(ResourceResolverType.JCR_MOCK);

    @Before
    public void setup(){
        PlumberImpl plumberImpl = new PlumberImpl();
        plumberImpl.activate();
        plumberImpl.registerPipe("slingPipes/dummy", Dummy.class);
        plumberImpl.registerPipe("slingPipes/dummySearch", DummySearch.class);
        plumber = plumberImpl;
        context.load().json("/fruits.json", PATH_FRUITS);
    }

}