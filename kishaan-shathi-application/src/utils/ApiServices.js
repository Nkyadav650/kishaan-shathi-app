import axios from "axios";


//for save the student
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