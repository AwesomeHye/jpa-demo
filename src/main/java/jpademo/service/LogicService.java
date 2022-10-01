package jpademo.service;

import jpademo.dto.Member;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
public class LogicService {
    public void process(EntityManager manager) {
        String id = "ID1";

        // 생성
        Member member = new Member(id, "hyein", 20);
        manager.persist(member);

        // 한 건 조회
        Member findMember = manager.find(Member.class, id);
        log.info("find: {}", findMember);

        // 수정
        member.setAge(10);

        // 목록 조회
        List<Member> findMemberList = manager.createQuery("Select m from Member m", Member.class).getResultList();
        log.info("find list: {}", findMemberList);

        // 삭제
        manager.remove(member);

        // 목록 조회
        findMemberList = manager.createQuery("Select m from Member m", Member.class).getResultList();
        log.info("find list: {}", findMemberList);
    }
}
