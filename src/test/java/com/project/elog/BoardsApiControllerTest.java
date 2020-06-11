package com.project.elog;

import com.project.elog.common.PostType;
import com.project.elog.common.ProviderType;
import com.project.elog.dto.BoardSaveRequestDto;
import com.project.elog.entity.Board;
import com.project.elog.entity.User;
import com.project.elog.respository.BoardRepository;
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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BoardRepository boardRepository;

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
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestDto, String.class);

        //then
        assertThat(responseEntity.getStatusCode(), is(equalTo(HttpStatus.OK)));
        //assertThat(responseEntity.getBody(), is(emptyOrNullString()));
        System.out.println(responseEntity.getBody());

        List<Board> boards = boardRepository.findAll();
        assertThat(boards.get(0).getTitle(), is(equalTo("아무제목")));
        assertThat(boards.get(0).getContent(), is(equalTo("아무내용")));

    }
}
