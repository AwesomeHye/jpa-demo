package jpademo;

import jpademo.service.LogicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@RequiredArgsConstructor
@Slf4j
public class JpaDemoApplication {

    public static void main(String[] args) {
        LogicService logicService = new LogicService();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpabook");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            logicService.process(manager);
            transaction.commit();
        } catch (Exception e) {
            log.error(e.getMessage());
            transaction.rollback();
        } finally {
            manager.close();
        }

        factory.close();
    }
}
