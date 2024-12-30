import React from 'react'
import { MDBFooter, MDBContainer, MDBRow, MDBCol, MDBIcon } from 'mdb-react-ui-kit';
import '../assets/styles/Footer.css';

const Footer = () => {
  const products = process.env.REACT_APP_PRODUCT ? process.env.REACT_APP_PRODUCT.split(',') : [];
  return (
    <div>
      <MDBFooter >
        <section className='d-flex justify-content-center justify-content-lg-between p-4 border-bottom'>
          <div className='me-5 d-none d-lg-block'>
            <span>Get connected with us on social networks:</span>
          </div>

          <div>
            {/* Social Media Links */}
            <a href={process.env.REACT_APP_FACEBOOK_URL} className='me-4 text-reset'>
              <MDBIcon color='secondary' fab icon='facebook-f' />
            </a>
            <a href={process.env.REACT_APP_TWITTER_URL} className='me-4 text-reset'>
              <MDBIcon color='secondary' fab icon='twitter' />
            </a>
            <a href={process.env.REACT_APP_GOOGLE_URL} className='me-4 text-reset'>
              <MDBIcon color='secondary' fab icon='google' />
            </a>
            <a href={process.env.REACT_APP_INSTAGRAM_URL} className='me-4 text-reset'>
              <MDBIcon color='secondary' fab icon='instagram' />
            </a>
            <a href={process.env.REACT_APP_LINKEDIN_URL} className='me-4 text-reset'>
              <MDBIcon color='secondary' fab icon='linkedin' />
            </a>
            <a href={process.env.REACT_APP_GITHUB_URL} className='me-4 text-reset'>
              <MDBIcon color='secondary' fab icon='github' />
            </a>
          </div>
        </section>

        <section className=''>
          <MDBContainer className='text-center text-md-start mt-5'>
            <MDBRow className='mt-3'>
              <MDBCol md='3' lg='4' xl='3' className='mx-auto mb-4'>
                <h6 className='text-uppercase fw-bold mb-4'>
                  <MDBIcon color='secondary' icon='gem' className='me-3' />
                  {process.env.REACT_APP_COMPANY_NAME}
                </h6>
                <p>
                  {process.env.REACT_APP_COMPANY_DESC}
                </p>
              </MDBCol>

              <MDBCol md='2' lg='2' xl='2' className='mx-auto mb-4'>
                <h6 className='text-uppercase fw-bold mb-4'>Products</h6>
                <p>
                  <a href='#!' className='text-reset'>
                    {products[0]}
                  </a>
                </p>
                <p>
                  <a href='#!' className='text-reset'>
                  {products[1]}
                  </a>
                </p>
                <p>
                  <a href='#!' className='text-reset'>
                  {products[2]}
                  </a>
                </p>
                <p>
                  <a href='#!' className='text-reset'>
                  {products[3]}
                  </a>
                </p>
              </MDBCol>

              <MDBCol md='3' lg='2' xl='2' className='mx-auto mb-4'>
                <h6 className='text-uppercase fw-bold mb-4'>Useful links</h6>
                <p>
                  <a href='#!' className='text-reset'>
                    Pricing
                  </a>
                </p>
                <p>
                  <a href='#!' className='text-reset'>
                    Settings
                  </a>
                </p>
                <p>
                  <a href='#!' className='text-reset'>
                    Orders
                  </a>
                </p>
                <p>
                  <a href='#!' className='text-reset'>
                    Help
                  </a>
                </p>
              </MDBCol>

              <MDBCol md='4' lg='3' xl='3' className='mx-auto mb-md-0 mb-4'>
                <h6 className='text-uppercase fw-bold mb-4'>Contact</h6>
                <p>
                  <MDBIcon color='secondary' icon='home' className='me-2' />
                  {process.env.REACT_APP_CONTACT_ADDRESS}
                </p>
                <p>
                  <MDBIcon color='secondary' icon='envelope' className='me-3' />
                  {process.env.REACT_APP_CONTACT_EMAIL}
                </p>
                <p>
                  <MDBIcon color='secondary' icon='phone' className='me-3' />
                  {process.env.REACT_APP_CONTACT_PHONE}
                </p>
                <p>
                  <MDBIcon color='secondary' icon='print' className='me-3' />
                  {process.env.REACT_APP_CONTACT_FAX}
                </p>
              </MDBCol>
            </MDBRow>
          </MDBContainer>
        </section>

        <div className='text-center p-4' style={{ backgroundColor: 'rgba(0, 0, 0, 0.05)' }}>
          © {process.env.REACT_APP_COPYRIGHT_YEAR} Copyright:
          <a className='text-reset fw-bold' href='https://mdbootstrap.com/'>
            KishaanShathi.com
          </a>
        </div>
      </MDBFooter>
    </div>
  )
}

export default Footer;
