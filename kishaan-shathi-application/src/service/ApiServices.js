import axios from "axios";

const jwtToken= localStorage.getItem("jwtToken")
//for save the student signup
export async function saveStudentApi(data) {
   
    return await axios.post('http://localhost:2024/user/createUser', data, {
       headers: {
          'Content-Type': 'application/json'
       }
    })
} 

//login api
export async function loginApi(data){
   return await axios.post('http://localhost:2024/user/manual/login',
      data,{
         headers:{
            'Content-Type':'application/json'
         }
      }
   )
}

export async function addCropApi(data) {
   console.log("jwtToken: ",jwtToken);
   
   try {
      const response = await axios.post('http://localhost:2024/crop/add', data, {
         headers: {
            'Content-Type': 'application/json',
            'token': jwtToken 
         }
      });
      return response.data; 
   } catch (error) {
      console.error('Error adding crop:', error); 
      throw error; 
   }
}
