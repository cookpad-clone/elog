package com.project.elog;

import com.project.elog.common.PostType;
import com.project.elog.common.ProviderType;
import com.project.elog.dto.BoardSaveRequestDto;
import com.project.elog.entity.Board;
import com.project.elog.entity.User;
import com.project.elog.respository.BoardRepository;
import com.project.elog.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserService userService;

    @AfterEach
    public void teardown() throws Exception{
        boardRepository.deleteAll();
    }

    @Test
    public void 글_등록된다() throws Exception{
        //given
        User user = User.builder()
                .email("nobin@nobin.com")
                .imageUrl(null)
                .name("병호띄")
                .providerType(ProviderType.FACEBOOK)
                .build();

        user = userService.addUser(user);
        System.out.println(user.toString());

        BoardSaveRequestDto requestDto = BoardSaveRequestDto.builder()
                .cntAccuVisitor(0)
                .cntVisitor(0)
                .content("아무내용")
                .postParent(null)
                .postType(PostType.NORMAL)
                .registerUser(user)
                .tags(null)
                .title("아무제목")
                .build();

        String url = "http://localhost:"+port+"/api/v1/boards";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isNotNull();

        List<Board> boards = boardRepository.findAll();
        assertThat(boards).isNotEmpty();
        assertThat(boards.get(0).getTitle()).isEqualTo("아무제목");
        assertThat(boards.get(0).getContent()).isEqualTo("아무내용");
    }
}
