package org.komodo.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.komodo.datavirtualization.SourceSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SourceSchemaTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private WorkspaceManagerImpl workspaceManagerImpl;

    @Test
    public void testFindDeleteByName() {
        SourceSchema s = new SourceSchema("foo");
        s.setName("bar");
        s.setDdl("create ...");
        entityManager.persist(s);
        entityManager.flush();

        org.komodo.datavirtualization.SourceSchema found = workspaceManagerImpl.findSchema(s.getId());
        assertEquals(s.getDdl(), found.getDdl());

        try {
            workspaceManagerImpl.createOrUpdateSchema(s.getId(), "foo", "create something...");
        } catch (IllegalArgumentException e) {
            //don't allow the schema name to change
        }

        workspaceManagerImpl.createOrUpdateSchema(s.getId(), "bar", "create something...");

        assertTrue(workspaceManagerImpl.deleteSchema(s.getId()));

        assertNull(workspaceManagerImpl.findSchema(s.getId()));

        assertFalse(workspaceManagerImpl.deleteSchema(s.getId()));

        entityManager.flush();
    }

}
