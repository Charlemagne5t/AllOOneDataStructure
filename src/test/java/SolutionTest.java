import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");
        Assert.assertEquals("hello", allOne.getMaxKey());
        Assert.assertEquals("hello", allOne.getMinKey());
        allOne.inc("leet");
        Assert.assertEquals("hello", allOne.getMaxKey());
        Assert.assertEquals("leet", allOne.getMinKey());
    }
    @Test
    public void test2() {
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("b");
        allOne.dec("b");
        allOne.dec("b");
        Assert.assertEquals("b", allOne.getMaxKey());
        Assert.assertEquals("a", allOne.getMinKey());

    }
    @Test
    public void test3() {
        AllOne allOne = new AllOne();
        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("c");
        allOne.inc("c");
        allOne.inc("c");
        allOne.dec("b");
        allOne.dec("b");
        Assert.assertEquals("a", allOne.getMinKey());
        allOne.dec("a");
        Assert.assertEquals("c", allOne.getMaxKey());
        Assert.assertEquals("c", allOne.getMinKey());


    }
    @Test
    public void test4() {
        AllOne allOne = new AllOne();
        allOne.inc("hello");
        allOne.inc("world");
        allOne.inc("hello");
        allOne.dec("world");
        allOne.inc("hello");
        allOne.inc("leet");

        Assert.assertEquals("hello", allOne.getMaxKey());



    }
}
