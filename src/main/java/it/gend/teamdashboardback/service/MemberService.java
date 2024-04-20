package it.gend.teamdashboardback.service;

import it.gend.teamdashboardback.entity.Member;
import it.gend.teamdashboardback.repository.MemberRepository;
import it.gend.teamdashboardback.utils.IdGenerator;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Daniele Asteggiante
 */
@Service
@Slf4j
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;
    private final IdGenerator idGenerator;

    public MemberService(MemberRepository memberRepository, IdGenerator idGenerator) {
        this.memberRepository = memberRepository;
        this.idGenerator = idGenerator;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberByName(String name) {
        return memberRepository.findByNameLikeIgnoreCase(name);
    }

    public Member saveMember(Member member) {
        member.setId(idGenerator.getId(Member.class));
        return memberRepository.save(member);
    }

    public Member deleteMember(long id) {
        Member member = memberRepository.findById(id).orElseThrow();
        memberRepository.delete(member);
        return member;
    }
}
