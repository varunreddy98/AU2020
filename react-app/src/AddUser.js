import React, { useState,Fragment } from 'react'
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
const AddUser=({addUser})=>{
	const [newname,onNewName]=useState('');
	const [newusername,onNewUserName]=useState('');

	return (
		<Fragment>
		<TextField id="name" label="Name" value={newname}  onChange={e=>onNewName(e.currentTarget.value)} variant="outlined" />
		<TextField id="username" label="Username" value={newusername}  onChange={e=>onNewUserName(e.currentTarget.value)} variant="outlined" />
		<Button variant="contained" color="secondary" onClick={() =>addUser({name:newname,username:newusername})}>Submit</Button>
	 </Fragment>
	)
}

export default AddUser
