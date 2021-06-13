package com.todo.app.mvc.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.app.mvc.domain.BaseResponse;
import com.todo.app.mvc.domain.BaseResponseCode;
import com.todo.app.mvc.domain.CompleteRate;
import com.todo.app.mvc.domain.TodoList;
import com.todo.app.mvc.domain.TodoListParameter;
import com.todo.app.mvc.exception.BaseException;
import com.todo.app.mvc.service.TodoListService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author  	: Mr.K
 * @Date 		: 2021. 5. 24.
 * @Version 	: 1.0
 * @Method Info : TodoController
 */
@RestController
@RequestMapping("/todo")
@Api(tags="Todo API")
public class TodoController {
	
	private final TodoListService todoListService;

	public TodoController(TodoListService todoListService) {
		this.todoListService = todoListService;
	}
	 
	Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 등록/수정
	 * @param todolist
	 * @return	
	 */
	@PostMapping("/save")
	@ApiOperation(value="등록 / 수정 처리", notes="신규 일정 저장 및 기존 일정 업데이트할때 사용")
	@ApiImplicitParams({
		@ApiImplicitParam(name="seq", value="일정 번호",  example="1"),
		@ApiImplicitParam(name="context", value="일정 내용",  example="코딩하기"),
		@ApiImplicitParam(name="targetDt", value="일정 기간",  example="2021-05-29")
	})
	public BaseResponse<String> save(@RequestBody TodoListParameter todoListParameter){
		if(StringUtils.isEmpty(todoListParameter.getContext())) {
			throw new BaseException(BaseResponseCode.VALIDATE_REQUIED, new String[]{"context","일정 내용"});
		}
		if(StringUtils.isEmpty(todoListParameter.getTargetDt())) {
			throw new BaseException(BaseResponseCode.VALIDATE_REQUIED, new String[]{"tagetDt","일정 기간"});
		}
		if(StringUtils.isEmpty(todoListParameter.getRegId())) {
			throw new BaseException(BaseResponseCode.VALIDATE_REQUIED, new String[]{"regId","작성자"});
		}
		logger.debug("저장하기 : {}",todoListParameter);
		todoListService.saveTodoList(todoListParameter);
		return new BaseResponse<String>(todoListParameter.getSeq());
	}
	
	/**
	 * 일정 완료여부변경
	 * @param todolist
	 * @return	
	 */
	@PutMapping("/updatestatus")
	@ApiOperation(value="일정완료여부 변경", notes="일정 완료여부 변경")
	@ApiImplicitParams({
		@ApiImplicitParam(name="seq", value="일정 번호",  example="1"),
		@ApiImplicitParam(name="isComplete", value="일정 완료여부",  example="Y"),
	})
	public BaseResponse<Boolean> updatestatus(TodoList todoList){
		if(StringUtils.isEmpty(todoList.getSeq())) {
			throw new BaseException(BaseResponseCode.VALIDATE_REQUIED, new String[]{"seq","일정 번호"});
		}
		TodoList result = todoListService.findOneTodoList(todoList.getSeq());
		if(result == null) {
			return new BaseResponse<Boolean>(false);
		}
		
		todoListService.updateTodoListComplete(todoList);
		return new BaseResponse<Boolean>(true);
	}
	
	
	/**
	 * 일정 삭제하기
	 * @param seq
	 * @return	
	 */
	@DeleteMapping("/{seq}")
	@ApiOperation(value="삭제 처리", notes = "일정 번호에 해당하는 정보를 삭제")
	@ApiImplicitParams({
		@ApiImplicitParam(name="seq", value="일정 번호", example="1")
	})
	public BaseResponse<Boolean> delete(@PathVariable String seq){
		TodoList result = todoListService.findOneTodoList(seq);
		if(result == null) {
			return new BaseResponse<Boolean>(false);
		}
		
		todoListService.deleteTodoList(seq);
		return new BaseResponse<Boolean>(true);
	}
	
	/**
	 * 일정 상세보기
	 * @param seq
	 * @return	
	 */
	@GetMapping("/{seq}")
	@ApiOperation(value="일정 상세보기", notes="일정 번호에 해당하는 상세 정보를 조회")
	@ApiImplicitParams({
		@ApiImplicitParam(name="seq", value="일정 번호", example="1")
	})
	public BaseResponse<TodoList> get(@PathVariable String seq){
		TodoList result = todoListService.findOneTodoList(seq);
		if(result == null) {
			throw new BaseException(BaseResponseCode.DATA_IS_NULL, new String[] {"일정"});
		}
		logger.debug("일정상세보기 : {}",result);
		return new BaseResponse<TodoList>(result);
	}
	
	/**
	 * 일정 전체 조회
	 * @return	
	 */
	@GetMapping("/list")
	@ApiOperation(value="특정일 일정 전체 가져오기", notes="특정일의 일정 전체를 조회")
	public BaseResponse<List<TodoList>> getList(){
		return new BaseResponse<List<TodoList>>(todoListService.getAllTodoListByDay());
	}
	
	@GetMapping("/completeRate/{targetDt}")
	@ApiOperation(value="특정일의 완료율 가져오기", notes="특정일의 완료율 조회")
	public BaseResponse<CompleteRate> getCompleteRate(@PathVariable String targetDt){
//		프론트엔드에서 인증 부분 구현 되면 오픈예정
//		if(StringUtils.isEmpty(regId)) {
//			throw new BaseException(BaseResponseCode.VALIDATE_REQUIED, new String[]{"regId","등록자 ID"});
//		}
		if(StringUtils.isEmpty(targetDt)) {
			throw new BaseException(BaseResponseCode.VALIDATE_REQUIED, new String[]{"targetDt","조회할 날짜"});
		}
		
		return new BaseResponse<CompleteRate>(todoListService.getCompleteRate(targetDt));
	}
}
