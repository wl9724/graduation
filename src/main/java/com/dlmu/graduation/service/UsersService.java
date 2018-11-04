package com.dlmu.graduation.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import com.dlmu.graduation.dao.UsersMapper;
import com.dlmu.graduation.dao.entity.Users;
import com.dlmu.graduation.dao.entity.UsersExample;
import com.dlmu.graduation.model.InformationRequest;
import com.dlmu.graduation.model.InformationResponse;
import com.dlmu.graduation.model.LoginRequest;
import com.dlmu.graduation.model.LoginResponse;
import com.dlmu.graduation.model.OfflineRequest;
import com.dlmu.graduation.model.OfflineResponse;
import com.dlmu.graduation.model.RegisterRequest;
import com.dlmu.graduation.model.RegisterResponse;
import com.dlmu.graduation.model.UpdateRequest;
import com.dlmu.graduation.model.UpdateResponse;

@Service
@Slf4j
public class UsersService {

	@Autowired
	UsersMapper usersMapper;
	
	/**
	 * 查询登录状态以及账户密码是否正确
	 * @param loginRequest
	 * @return
	 */
	public LoginResponse login(LoginRequest loginRequest) {
		
		UsersExample example = new UsersExample();
		
		

		example.or()
			.andUsernameEqualTo(loginRequest.getUsername())
			.andPasswordEqualTo(loginRequest.getPassword());
		
		List<Users> users = usersMapper.selectByExample(example);
		
		log.info("userservice"+users);

		if(!users.isEmpty() && users.get(0).getLoginstatus() == 0) {
			
			users.get(0).setLoginstatus((byte) 1);
			
			usersMapper.updateByPrimaryKey(users.get(0));
			
			return new LoginResponse(users.get(0).getId(),true);
			
		}else {
			
			return new LoginResponse(0,false);
			
		}
		
	}

	/**
	 * 查询用户信息
	 * @param informationRequest
	 * @return
	 */
	public InformationResponse getInformation(InformationRequest informationRequest){

		Users users = usersMapper.selectByPrimaryKey(informationRequest.getId());

		InformationResponse informationResponse = new InformationResponse();

		informationResponse.setId(users.getId());
		informationResponse.setUsername(users.getUsername());
		informationResponse.setPassword(users.getPassword());
		informationResponse.setPhone(users.getPhone());
		informationResponse.setEmail(users.getEmail());

		return informationResponse;

	}

	/**
	 * 登录下线
	 * @param offlineRequest
	 * @return
	 */
	public OfflineResponse offline(OfflineRequest offlineRequest) {
		
		Users users = new Users();

		users.setId(offlineRequest.getId());
		users.setLoginstatus((byte)0);

		int flag = usersMapper.updateByPrimaryKeySelective(users);

		if (flag == 0) {
			return new OfflineResponse(false);
		}

		return new OfflineResponse(true);

	}

	/**
	 * 修改用户信息
	 * @param updateRequest
	 * @return
	 */
	public UpdateResponse update(UpdateRequest updateRequest) {

		Users users = new Users();
		users.setId(updateRequest.getId());
		users.setUsername(updateRequest.getUsername());
		users.setPassword(updateRequest.getPassword());
		users.setPhone(updateRequest.getPhone());
		users.setEmail(updateRequest.getEmail());
		users.setUpdated(new Date());

		int flag = usersMapper.updateByPrimaryKeySelective(users);

		if (flag == 0) {
			return new UpdateResponse(false);
		}

		return new UpdateResponse(true);
	}

	/**
	 * 注册
	 * @param registerRequest
	 * @return
	 */
	public RegisterResponse register(RegisterRequest registerRequest) {

		Users users = new Users();
		users.setUsername(registerRequest.getUsername());
		users.setPassword(registerRequest.getPassword());
		users.setPhone(registerRequest.getPhone());
		users.setEmail(registerRequest.getEmail());
		users.setCreated(new Date());
		users.setUpdated(new Date());

		int flag = usersMapper.insertSelective(users);

		if (flag == 0) {
			return new RegisterResponse(false);
		}

		return new RegisterResponse(true);
	}
	
}
