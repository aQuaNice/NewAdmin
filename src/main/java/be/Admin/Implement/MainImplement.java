package be.Admin.Implement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import be.Admin.Model.Member;
import be.Admin.Model.NewPackage;
import be.Admin.Model.Result;
import be.Admin.Service.MainService;
@Service
public class MainImplement implements MainService{
	@Autowired
	JdbcTemplate jTemplate;
	
	@Override
	public void getDataNewMember(Result result) throws Exception {
		JSONArray laResult = new JSONArray();
		JSONObject loResult = new JSONObject();	
		JSONObject lcData = new JSONObject();
		//		String sql ="SELECT count(id) as jumlah FROM tbm_member WHERE validat = ? ";
		//		int total = jTemplate.queryForObject(sql, args, int.class); // singgle page

		String sql ="SELECT 'New Member' as lcnm,'1'  as lckode , count(id) as jumlah FROM tbm_member WHERE validat = ?"
				+ " Union "
				+ "SELECT  'New Order' as lcnm , '2'  as lckode ,count(id) as jumlah FROM tbm_h_order WHERE stat = ?"
				+ " Union "
				+ "SELECT  'Order On Packing' as lcnm,  '3'  as lckode ,count(id) as jumlah FROM tbm_h_order WHERE stat = ?"
				+ " union "
				+ "SELECT  'Order To Delivery' as lcnm,  '4'  as lckode ,count(id) as jumlah FROM tbm_h_order WHERE stat = ?";
//				+ " union "
//				+ "SELECT  'deliver' as lcnm,  '5'  as lckode ,count(id) as jumlah FROM tbm_h_order WHERE stat = ?";

		Object[] args = new Object[]{0,0,1,2};

		try{
			List <NewPackage> lcList = jTemplate.query(sql, args, new RowMapper<NewPackage>() {
				@Override
				public NewPackage mapRow(ResultSet resultQue, int rowNum) throws SQLException {
					NewPackage objList = new NewPackage();
					objList.setLckode(resultQue.getInt("lckode"));
					objList.setLcnm(resultQue.getString("lcnm"));
					objList.setJumlah(resultQue.getInt("jumlah"));
					return objList; } });	

			for (NewPackage aList : lcList) {	
				loResult = new JSONObject();
				loResult.put("lckode", aList.getLckode());
				loResult.put("lcnm", aList.getLcnm());
				loResult.put("jumlah", aList.getJumlah());
				laResult.add(loResult); }

//			lcData.put("newCom",laResult);
//			result.setRsltobject(lcData);
			result.setRsltArray(laResult);
		}catch(Exception e){
			e.printStackTrace();
			//				result.setResulcd("24");
		}
	}






	@Override
	public void getDataNewOrder(Result result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getDataPacking(Result result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getDataPendingDelivery(Result result) {
		// TODO Auto-generated method stub

		//		int id= jTemplate.queryForObject(sql, args);
		//		(sql, Long.class);

		//jTemplate.query(sql, args, new RowMapper<Result>() {
		////@Override
		//public Result mapRow(ResultSet resultQue, int rowNum) throws SQLException {
		////	System.out.println("data from dbs :"+result.getString("invoorder"));
		//	Result objList = new Result();		
		//	
		//	result.setResultmsg(resultQue.getString("jumlah"));
		////	System.out.println(resultQue.getInt("jumlah"));
		////	objList.setLcinvoorder(resultQue.getString("invoorder"));
		////	objList.setLcid(resultQue.getLong("id"));
		////	objList.setLctglexp(resultQue.getDate("tglexp"));
		////	objList.setLctglord(resultQue.getDate("tglord"));
		////	objList.setLcordtotal(resultQue.getFloat("ordtotal"));
		////	objList.setLcstat(resultQue.getInt("stat"));
		//	return objList;
		//}
		//});	


		//String lcstat = prop.getProperty("message0");
		//System.out.println(lcstat);

		//for (Member aList : execute) {	
		//String lcstat = prop.getProperty("message"+lcdata.getLcstat());
		//loResult = new JSONObject();
		//loResult.put("lcid", aList.getLcid());
		//loResult.put("lcinvoorder", aList.getLcinvoorder());
		//loResult.put("lcstat", lcstat);
		//loResult.put("lcstatcd", aList.getLcstat());
		//loResult.put("lcordtotal", aList.getLcordtotal());
		//loResult.put("lctglord", aList.getLctglord());
		//loResult.put("lctglexp", aList.getLctglexp());	
		//laResult.add(loResult);
		//}


		//System.out.println("List Of DATA :"+laResult);
	}





}
