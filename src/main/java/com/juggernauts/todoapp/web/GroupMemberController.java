//package com.juggernauts.todoapp.web;
//
//import com.juggernauts.todoapp.models.EmailVerification;
//import com.juggernauts.todoapp.models.GroupMember;
//import com.juggernauts.todoapp.services.EmailVerificationService;
//import com.juggernauts.todoapp.services.GroupMemberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//@RequestMapping("groupMember")
//public class GroupMemberController {
//
//    @Autowired
//    GroupMemberService groupMemberService;
//
//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity createNewGroupMember(@RequestBody GroupMember groupMember) {
//        groupMemberService.addGroupMember(groupMember);
//        return ResponseEntity.ok(groupMember);
//    };
//}
