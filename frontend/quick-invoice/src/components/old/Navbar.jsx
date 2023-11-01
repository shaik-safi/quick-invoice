import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import { Link} from 'react-router-dom';
function Header() {
  return (
    <>
      <Navbar bg="dark" data-bs-theme="dark" expand="lg">
      <Container>
      <Navbar.Brand as={Link} to="/">Navbar</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
          <Nav.Link as={Link} to="/client">Client</Nav.Link>
          {/* <Nav.Link as={Link} to="/company">Company</Nav.Link>
          <Nav.Link as={Link} to="/company">Company</Nav.Link>
          <Nav.Link as={Link} to="/company">Company</Nav.Link>
          <Nav.Link as={Link} to="/company">Company</Nav.Link> */}
            {/* <NavDropdown title="Client" id="basic-nav-dropdown"> */}
            {/* <Nav.Link as={Link} to="/add-client">Add Client</Nav.Link>
            <Nav.Link as={Link} to="/list-client">List Client</Nav.Link>
            </NavDropdown>
            <Nav.Link as={Link} to="/add-invoice">Invoice</Nav.Link>
            <Nav.Link as={Link} to="/generate-pdf">Generate PDF</Nav.Link>
            <Nav.Link as={Link} to="/test">Test</Nav.Link> */}
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  
      </>
  );
}

export default Header;