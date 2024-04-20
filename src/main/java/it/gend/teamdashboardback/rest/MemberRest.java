package it.gend.teamdashboardback.rest;

import it.gend.teamdashboardback.entity.Member;
import it.gend.teamdashboardback.service.MemberService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Daniele Asteggiante
 */

@RestController
@RequestMapping("api/member")
@Slf4j
public class MemberRest {

    private final MemberService memberService;

    public MemberRest(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMemebers() {
        log.info("getAllMembers");
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @GetMapping("{name}")
    public ResponseEntity<Member> getMemberByName(@PathVariable String name) {
        log.info("getMemberByName");
        return ResponseEntity.ok(memberService.getMemberByName(name));
    }

    @PostMapping
    public ResponseEntity<Member> saveMember(@RequestBody Member member) {
        log.info("saveMember");
        return ResponseEntity.ok(memberService.saveMember(member));
    }

    @PutMapping
    public ResponseEntity<Member> updateMember(@RequestBody Member member) {
        log.info("updateMember");
        return ResponseEntity.ok(memberService.saveMember(member));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Member> deleteMember(@PathVariable long id) {
        return ResponseEntity.ok(memberService.deleteMember(id));
    }

}
