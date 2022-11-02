package schjoin.SCH.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import schjoin.SCH.dto.AddUserDto;
import schjoin.SCH.dto.LoginDto;
import schjoin.SCH.response.DefaultRes;
import schjoin.SCH.response.StatusCode;
import schjoin.SCH.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    //회원 가입
    @PostMapping("users/creation")
    public ResponseEntity createMember(@RequestBody @Validated AddUserDto addUserDto){
        Long userId = userService.createMember(addUserDto);

        return userId != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "회원가입 완료"), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.BAD_REQUEST, "잘못된 요청"), HttpStatus.OK);
    }



    //로그인
    @PostMapping("users/login")
    public ResponseEntity login(@RequestBody @Validated LoginDto loginDto){
        Long userId = userService.login(loginDto);

        return userId != null ?
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "로그인 완료",userId), HttpStatus.OK) :
                new ResponseEntity(DefaultRes.res(StatusCode.OK, "로그인 실패"), HttpStatus.OK);
    }


}
