package com.project.elog.api;

import com.project.elog.apiversion.ApiVersion;
import com.project.elog.apiversion.Version;
import com.project.elog.dto.BoardSaveRequestDto;
import com.project.elog.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/api/v1/boards")
    public Long save(@RequestBody BoardSaveRequestDto requestDto){
        return boardService.save(requestDto);
    }

    @ApiVersion(version = Version.V1)
    @DeleteMapping(path="/api/boards/{boardId}")
    public void delete(@PathVariable Long boardId){
        boardService.delete(boardId);
    }
}
