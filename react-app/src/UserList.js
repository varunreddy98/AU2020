import React from 'react'
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
const useStyles = makeStyles({
    table: {
      minWidth: 650,
    },
  });
  const UserList = props => (
    <TableContainer component={Paper}>
        <Table aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell align="center">Name</TableCell>
              <TableCell align="center">Username</TableCell>
              <TableCell align="center">Edit</TableCell>
              <TableCell align="center">Delete</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {props.users.map(row => (
              <TableRow key={row.name}>
                <TableCell align="center" component="th" scope="row">{row.name}</TableCell>
                <TableCell align="center">{row.username}</TableCell>
                <TableCell align="center" component="th" scope="row"> <Button variant="contained" color="secondary"  onClick={() => {props.editRow(row)
                }}>Edit</Button></TableCell>
                <TableCell align="center" component="th" scope="row"> <Button variant="contained" color="secondary" onClick={() => props.deleteUser(row.id)}>Delete</Button></TableCell>
              
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>

  );

export default UserList;