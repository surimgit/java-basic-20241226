package com.korit.crud;

import java.sql.Connection;
import java.util.Scanner;

import com.korit.crud.controller.AuthController;
import com.korit.crud.controller.BoardController;
import com.korit.crud.controller.UserController;
import com.korit.crud.controller.implement.AuthControllerImplement;
import com.korit.crud.controller.implement.BoardControllerImplement;
import com.korit.crud.controller.implement.UserControllerImplement;
import com.korit.crud.db.MySQLConnector;
import com.korit.crud.dto.auth.SignInRequestDto;
import com.korit.crud.dto.auth.SignUpRequestDto;
import com.korit.crud.dto.board.PatchBoardRequestDto;
import com.korit.crud.dto.board.PostBoardRequestDto;
import com.korit.crud.dto.user.DeleteSignInUserRequestDto;
import com.korit.crud.dto.user.PatchSignInUserRequestDto;
import com.korit.crud.repository.BoardRepository;
import com.korit.crud.repository.UserRepository;
import com.korit.crud.repository.implement.BoardRepositoryImplement;
import com.korit.crud.repository.implement.UserRepositoryImplement;
import com.korit.crud.service.AuthService;
import com.korit.crud.service.BoardService;
import com.korit.crud.service.UserService;
import com.korit.crud.service.implement.AuthServiceImplement;
import com.korit.crud.service.implement.BoardServiceImplement;
import com.korit.crud.service.implement.UserServiceImplement;

public class CrudApplication {
	
	public static String SESSION = null;

	public static void main(String[] args) {
		
		Connection connection = MySQLConnector.getInstance().getConnection();
		
		BoardRepository boardRepository = new BoardRepositoryImplement(connection);
		UserRepository userRepository = new UserRepositoryImplement(connection);
		BoardService boardService = new BoardServiceImplement(boardRepository, userRepository);
		AuthService authService = new AuthServiceImplement(userRepository);
		UserService userService = new UserServiceImplement(userRepository);
		BoardController boardController = new BoardControllerImplement(boardService);
		AuthController authController = new AuthControllerImplement(authService);
		UserController userController = new UserControllerImplement(userService);
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			
			String job = SESSION == null ? 
					"(로그인, 회원가입)" : "(정보보기, 정보수정, 정보삭제, 게시판)";
			System.out.print("작업 " + job + " : ");
			
			String request = scanner.nextLine();
			
			if (request.equals("exit")) break;
			
			if (request.equals("회원가입")) {
				SignUpRequestDto requestDto = new SignUpRequestDto();
				authController.signUp(requestDto);
			}
			if (request.equals("로그인")) {
				SignInRequestDto requestDto = new SignInRequestDto();
				authController.signIn(requestDto);
			}
			if (request.equals("정보보기")) {
				userController.getSignInUser();
			}
			if (request.equals("정보수정")) {
				PatchSignInUserRequestDto requestDto = new PatchSignInUserRequestDto();
				userController.patchSignInUser(requestDto);
			}
			if (request.equals("정보삭제")) {
				DeleteSignInUserRequestDto requestDto = new DeleteSignInUserRequestDto();
				userController.deleteSignInUser(requestDto);
			}
			if (request.equals("게시판")) {
				
				System.out.print("게시판 작업 (작성, 리스트 보기, 상세 보기, 수정, 삭제) : ");
				request = scanner.nextLine();
				
				if (request.equals("작성")) {
					PostBoardRequestDto requestDto = new PostBoardRequestDto();
					boardController.postBoard(requestDto);
				}
				
				if (request.equals("리스트 보기")) {
					boardController.getBoardList();
				}
				
				if (request.equals("상세 보기")) {
					try {
						System.out.print("게시물 번호: ");
						Integer boardNumber = Integer.parseInt(scanner.nextLine());
						
						boardController.getBoardView(boardNumber);
					} catch (Exception exception) {
						System.out.println("존재하지 않는 게시물입니다.");
					}
				}
				
				if (request.equals("수정")) {
					try {
						System.out.print("게시물 번호: ");
						Integer boardNumber = Integer.parseInt(scanner.nextLine());
						
						boolean isWriter = boardController.checkWriter(boardNumber);
						if (!isWriter) continue;
						
						PatchBoardRequestDto requestDto = new PatchBoardRequestDto();
						boardController.updateBoard(requestDto, boardNumber);
					} catch (Exception exception) {
						System.out.println("존재하지 않는 게시물입니다.");
					}
				}
				
				if (request.equals("삭제")) {
					try {
						System.out.print("게시물 번호: ");
						Integer boardNumber = Integer.parseInt(scanner.nextLine());
						
						boardController.deleteBoard(boardNumber);
					} catch (Exception exception) {
						System.out.println("존재하지 않는 게시물입니다.");
					}
				}
			}
		}
		
		scanner.close();
	}

}





