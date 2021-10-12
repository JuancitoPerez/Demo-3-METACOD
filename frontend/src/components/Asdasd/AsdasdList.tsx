import { Button, Container, Grid, Table,TableBody, TableCell, TableRow, TableContainer, TableHead, Paper} from '@mui/material';
import AddIcon from '@mui/icons-material/Add';
import AsdasdGetAllResponseDto from '../../dtos/Asdasd/getAll/AsdasdGetAllResponseDto';
import { useState } from 'react';
import { useHistory } from 'react-router';

export default function AsdasdList() {
    const [AsdasdList, setAsdasdList] = useState<AsdasdGetAllResponseDto[]>([]);
    const history = useHistory();

    const goToCreateViewHandler = ()=>{
      history.push('/Asdasd/create')
    }
return (
    <Container>
        <Grid container justifyContent="space-between" alignItems='center'>
          <Grid item><h2>Asdasd List</h2></Grid>
          <Grid item><Button color="primary" variant="contained" onClick={goToCreateViewHandler} size="small">
            <AddIcon/>Asdasd
          </Button></Grid>
        </Grid>

        <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
          </TableRow>
        </TableHead>
        <TableBody>
{AsdasdList.length > 0 ? AsdasdList.map((row) => (
            <TableRow
              key={row.AsdasdId}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
            </TableRow>
          )) : <p><strong>No hay registros para mostrar</strong></p>}
        </TableBody>
      </Table>
    </TableContainer>
    </Container>
)}
