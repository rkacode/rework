package com.blogspot.rkacode.students.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.function.Consumer;

@Component
public class TransactionExecutor {

    @Autowired
    PlatformTransactionManager transactionManager;

    @PersistenceContext
    EntityManager entityManager;

    public void runInTransaction(final Consumer<EntityManager> block) {
	TransactionStatus status = null;
	try {
	    TransactionDefinition transaction = new DefaultTransactionDefinition();
	    status = transactionManager.getTransaction(transaction);
	    block.accept(entityManager);
	} catch (Exception e) {
	    if (status != null) {
		transactionManager.rollback(status);
	    }
	    throw e;
	} finally {
	    if (status != null) {
		transactionManager.commit(status);
	    }
	}
    }

}
