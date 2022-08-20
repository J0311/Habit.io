//package com.juggernauts.todoapp.web;
//
//import com.juggernauts.todoapp.models.Group;
////import com.juggernauts.todoapp.models.GroupMember;
//import com.juggernauts.todoapp.models.GroupMember;
//import com.juggernauts.todoapp.models.User;
//import com.juggernauts.todoapp.repos.GroupMemberRepo;
//import com.juggernauts.todoapp.services.GroupService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Arrays;
//
//
//@RestController
//@RequestMapping("group")
//public class GroupController {
//
//    GroupMemberRepo groupMemberRepo;
//    @Autowired
//    public void setGroupMemberRepo(GroupMemberRepo groupMemberRepo) {
//        this.groupMemberRepo = groupMemberRepo;
//    }
//
//    GroupService groupService;
//    @Autowired
//    public void setGroupService(GroupService groupService) {
//        this.groupService = groupService;
//    }
//
//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity createNewGroup(@RequestBody Group group) {
//
////        User currentUser = new User(1, "testpassword", "testemail");
////        GroupMember groupMember = new GroupMember(true, currentUser);
//
////        group.setUsers(Arrays.asList(currentUser));
//
//        groupService.addGroup(group);
////        groupMemberRepo.save(groupMember);
//        return ResponseEntity.ok(group);
//    };
//}
